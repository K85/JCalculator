package com.sakurawald.event.events;

import com.sakurawald.bean.History;
import com.sakurawald.event.EventCenter;
import com.sakurawald.event.Listener;
import com.sakurawald.event.events.HistorySpawnEvent;
import org.junit.Test;

public class ReflectTest {

    @Test
    public void testGetGenericType() {
        Listener<HistorySpawnEvent> listener = new Listener<>() {
            @Override
            public void onEvent(HistorySpawnEvent event) {
                System.out.println("hi");
            }
        };
        System.out.println(listener.getClass().getName());
        System.out.println(listener.getClass().getGenericSuperclass());
        System.out.println(listener.getClass().getGenericSuperclass().getTypeName());
        System.out.println(listener.getEventName());
    }

    @Test
    public void testGetClassName() {
        History history = null;
        EventCenter.fire(new HistorySpawnEvent(history));
    }

}
