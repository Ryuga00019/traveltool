package com.github.aer0119.traveltool.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.github.aer0119.traveltool.domain.EventContent;
import com.github.aer0119.traveltool.domain.EventPlan;
import com.github.aer0119.traveltool.util.LRUCacheHashMap;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class EventPlanRepository {
    private final JdbcClient jdbcClient;

    private static final ObjectMapper mapper = new ObjectMapper();

    private final LRUCacheHashMap<UUID, EventPlan> cachedPlan = new LRUCacheHashMap<>(30); //cacheされる最大数

    @Autowired
    public EventPlanRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @PostConstruct
    private void init() {
        var jtm = new JavaTimeModule();
        jtm.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnnnnn")));
        jtm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnnnnn")));
        mapper.registerModule(jtm);
    }

    public void save(EventPlan eventPlan) {
        addCache(eventPlan);
        String sql = "INSERT INTO event_plan(plan_id, place_name, description, start_date, end_date, event_contents) " +
                "VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE " +
                "place_name = VALUES(place_name), description = VALUES(description), " +
                "start_date = VALUES(start_date), end_date = VALUES(end_date), event_contents = VALUES(event_contents)";
        var planId = eventPlan.getEventPlanId();
        var title = eventPlan.getPlaceName();
        var description = eventPlan.getDescription();
        var startDate = Timestamp.valueOf(eventPlan.getStartDate().atStartOfDay());
        var endDate = Timestamp.valueOf(eventPlan.getEndDate().atStartOfDay());
        try {
            var eventContentJson = mapper.writeValueAsString(eventPlan.getEventContents());
            jdbcClient.sql(sql)
                    .params(planId, title, description, startDate, endDate, eventContentJson)
                    .update();
        } catch (JsonProcessingException e) {
        }

    }

    public EventPlan find(UUID planId) { //IDを貰ってEventPlan を探してくる
        if (cachedPlan.containsKey(planId)) return cachedPlan.get(planId);
        String sql = "SELECT * FROM event_plan WHERE plan_id=?";
        var result = jdbcClient.sql(sql).params(planId).query(new EventPlanRowMapper()).optional();
        if (result.isPresent()) {
            addCache(result.get());
            return result.get();
        }
        return null;
    }

    public void delete(EventPlan eventPlan) {
        removeCache(eventPlan);
        String sql = "DELETE FROM event_plan WHERE plan_id=?";
        jdbcClient.sql(sql).param(eventPlan.getEventPlanId()).update();
    }

    private void addCache(EventPlan eventPlan) {
        if (cachedPlan.containsKey(eventPlan.getEventPlanId())) return;
        cachedPlan.put(eventPlan.getEventPlanId(), eventPlan);
    }

    private void removeCache(EventPlan eventPlan) {
        cachedPlan.remove(eventPlan.getEventPlanId());
    }

    private static class EventPlanRowMapper implements RowMapper<EventPlan> {

        @Override
        public EventPlan mapRow(ResultSet rs, int rowNum) throws SQLException {
            var planId = rs.getString("plan_id");
            var placeName = rs.getString("place_name");
            var description = rs.getString("description");
            var startDateTimestamp = rs.getTimestamp("start_date");
            var endDateTimestamp = rs.getTimestamp("end_date");
            var eventContentJson = rs.getString("event_contents");
            var startDate = startDateTimestamp.toLocalDateTime().toLocalDate();
            var endDate = endDateTimestamp.toLocalDateTime().toLocalDate();
            try {
                var ref = new TypeReference<List<EventContent>>() {};
                var eventContentList = mapper.readValue(eventContentJson, ref);
                var eventContent = new ArrayList<>(eventContentList);
                return new EventPlan(UUID.fromString(planId), placeName, description, startDate, endDate, eventContent);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
