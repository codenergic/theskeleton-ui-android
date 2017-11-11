package org.codenergic.theskeleton.data.helper;

import com.f2prateek.rx.preferences2.RxSharedPreferences;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public abstract class AbstractPreferences {

    protected final ObjectMapper objectMapper;

    private RxSharedPreferences rxSharedPreferences;

    private SharedPreferences sharedPreferences;

    public AbstractPreferences(Context context, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        initPreferences(context, getPreferencesGroup());
    }

    private void initPreferences(Context context, String preferencesGroup) {
        sharedPreferences = context.getSharedPreferences(preferencesGroup, 0);
        rxSharedPreferences = RxSharedPreferences.create(sharedPreferences);
    }

    public abstract String getPreferencesGroup();

    protected RxSharedPreferences getRxSharedPreferences() {
        return rxSharedPreferences;
    }

    protected void saveData(String tag, Long value) {
        rxSharedPreferences.getLong(tag).set(value);
    }

    protected void saveData(String tag, Boolean value) {
        rxSharedPreferences.getBoolean(tag).set(value);
    }

    protected void saveData(String tag, Integer value) {
        rxSharedPreferences.getInteger(tag).set(value);
    }

    protected void saveData(String tag, Float value) {
        rxSharedPreferences.getFloat(tag).set(value);
    }

    protected <T> void saveData(String tag, T obj) {
        try {
            saveData(tag, objectMapper.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void saveData(String tag, String value) {
        rxSharedPreferences.getString(tag).set(value);
    }

    protected <T> T getData(String tag, Class<T> classOfT) {
        String rawData = rxSharedPreferences.getString(tag).get();
        try {
            return objectMapper.readValue(rawData, classOfT);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected <T> T getData(String tag, TypeReference type) {
        String rawData = rxSharedPreferences.getString(tag).get();
        try {
            return objectMapper.readValue(rawData, type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected <T> Flowable<T> getDataAsFlowable(String tag, Class<T> classOfT) {
        return rxSharedPreferences.getString(tag)
            .asObservable()
            .toFlowable(BackpressureStrategy.LATEST)
            .map(rawData -> {
                T result = objectMapper.readValue(rawData, classOfT);
                if (result == null) {
                    try {
                        result = classOfT.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                return result;
            });
    }

    public Flowable<Boolean> clearData(String tag) {
        return Flowable.defer(() -> {
            if (sharedPreferences != null) {
                sharedPreferences.edit().remove(tag).apply();
                return Flowable.just(true);
            }
            return Flowable.just(false);
        });
    }

    public Flowable<Boolean> clearAllData() {
        return Flowable.defer(() -> {
            if (sharedPreferences != null) {
                sharedPreferences.edit().clear().apply();
                return Flowable.just(true);
            }
            return Flowable.just(false);
        });
    }

    protected String getString(String tag) {
        return rxSharedPreferences.getString(tag, null).get();
    }

    protected Flowable<String> getStringAsFlowable(String tag) {
        return rxSharedPreferences.getString(tag, null)
            .asObservable()
            .toFlowable(BackpressureStrategy.LATEST)
            .compose(RxTransformer.applyThreadTransformer());
    }

    protected Flowable<String> getStringAsFlowable(String tag, String defaultValue) {
        return rxSharedPreferences.getString(tag, defaultValue).asObservable()
            .toFlowable(BackpressureStrategy.LATEST)
            .compose(RxTransformer.applyThreadTransformer());
    }

    protected long getLong(String tag) {
        Long lng = rxSharedPreferences.getLong(tag).get();
        if (lng == null) {
            return 0;
        }
        return lng;
    }

    protected Flowable<Long> getLongAsFlowable(String tag) {
        return rxSharedPreferences.getLong(tag).asObservable()
            .toFlowable(BackpressureStrategy.LATEST)
            .compose(RxTransformer.applyThreadTransformer());
    }

    protected boolean getBoolean(String tag) {
        Boolean value = rxSharedPreferences.getBoolean(tag).get();
        if (value == null) {
            return false;
        }
        return value;
    }

    protected Flowable<Boolean> getBooleanAsFlowable(String tag) {
        return rxSharedPreferences.getBoolean(tag).asObservable()
            .toFlowable(BackpressureStrategy.LATEST)
            .compose(RxTransformer.applyThreadTransformer());
    }

    protected int getInteger(String tag) {
        Integer integer = rxSharedPreferences.getInteger(tag).get();
        if (integer == null) {
            return 0;
        }
        return integer;
    }

    protected Flowable<Integer> getIntegerAsFlowable(String tag) {
        return rxSharedPreferences.getInteger(tag).asObservable()
            .toFlowable(BackpressureStrategy.LATEST)
            .compose(RxTransformer.applyThreadTransformer());
    }

    protected float getFloat(String tag) {
        Float fl = rxSharedPreferences.getFloat(tag).get();
        if (fl == null) {
            return 0f;
        }
        return fl;
    }

    protected Flowable<Float> getFloatAsFlowable(String tag) {
        return rxSharedPreferences.getFloat(tag).asObservable()
            .toFlowable(BackpressureStrategy.LATEST)
            .compose(RxTransformer.applyThreadTransformer());
    }

}
