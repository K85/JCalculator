package com.sakurawald.event.events;

import com.sakurawald.bean.History;
import com.sakurawald.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistorySpawnEvent extends Event {
    private History spawnedHistory;
}
