package com.luxoft.korzch.dao.base;

import com.luxoft.korzch.base.Common;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.ArrayList;

import static com.luxoft.korzch.util.Util.isNotNull;

public abstract class Dao<T> implements Common<T> {

    protected BidiMap<Long, T> items = new DualHashBidiMap<>();

    @Override
    public ArrayList<T> getAll() {
        return new ArrayList<>(items.values());
    }

    @Override
    public T get(long id) {
        return items.get(id);
    }

    @Override
    public long create(T item) {
        long nextId = nextId();
        items.put(nextId, item);
        return nextId;
    }

    @Override
    public long update(T item) {
        long key = items.getKey(item);
        items.put(key, item);
        return key;
    }

    @Override
    public boolean delete(long id) {
        return isNotNull(items.remove(id));
    }

    private long nextId() {
        return items.size();
    }
}

