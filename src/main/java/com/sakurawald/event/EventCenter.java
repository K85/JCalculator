package com.sakurawald.event;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
public class EventCenter {

    private static final HashMap<String, ArrayList<Listener<? extends Event>>> events = new HashMap<>();

    public static String getEventName(Class<? extends Event> eventClass) {
        return eventClass.getName();
    }

    public static ArrayList<Listener<? extends Event>> getListeners(Class<? extends Event> eventClass) {
        return events.getOrDefault(getEventName(eventClass), new ArrayList<>());
    }

    public static void register(Listener<? extends Event> listener) {
        String eventName = listener.getEventName();
        log.debug("Registering listener for event {} -> listener = {}", eventName, listener);

        if (!events.containsKey(eventName)) {
            events.put(eventName, new ArrayList<>());
        }
        events.get(eventName).add(listener);
    }

    public static void unregister(Listener<? extends Event> listener) {
        String eventName = listener.getEventName();
        log.debug("Unregistering listener for event {} -> listener = {}", eventName, listener);

        if (events.containsKey(eventName)) {
            events.get(eventName).remove(listener);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends Event> void fire(T event) {
        log.debug("Firing event {}", event);

        for (Listener listener : EventCenter.getListeners(event.getClass())) {
            log.debug("Firing event {} -> listener = {}", event, listener);
            try {
                // the call to listener.onEvent() is not case-safe.
                listener.onEvent(event);
            } catch (Exception e) {
                log.error("Error while firing event {} -> listener = {}", event, listener, e);
            }
        }

    }

}
