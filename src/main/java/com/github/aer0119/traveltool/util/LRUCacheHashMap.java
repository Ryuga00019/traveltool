package com.github.aer0119.traveltool.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public LRUCacheHashMap(int maxSize) {
        super(15, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}
