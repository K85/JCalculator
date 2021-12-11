package com.sakurawald.event;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;

@Slf4j
public abstract class Listener<T extends Event> {

    public abstract void onEvent(T event);

    public String getEventName() {
        return ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
    }
}
