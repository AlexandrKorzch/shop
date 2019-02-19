package com.luxoft.korzch.dao.base;

import com.luxoft.korzch.base.Common;
import com.luxoft.korzch.domain.Model;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.ArrayList;
import java.util.List;

import static com.luxoft.korzch.util.Util.isNotNull;

public abstract class Dao<T extends Model> implements Common<T> {

    protected BidiMap<Long, T> items = new DualHashBidiMap<>();

    @Override
    public List<T> getAll() {
        return new ArrayList<>(items.values());
    }

    @Override
    public T get(long id) {
        return items.get(id);
    }

    @Override
    public long create(T item) {
        long id = nextId();
        item.setId(id);
        items.put(id, item);
        return id;
    }

    @Override
    public boolean update(T item) {
        long key = items.getKey(item);
        items.put(key, item);
        return true;
    }

    @Override
    public boolean delete(long id) {
        return isNotNull(items.remove(id));
    }

    private long nextId() {
        return items.size();
    }
}

