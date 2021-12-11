package com.sakurawald.event.events;

import com.sakurawald.bean.Memory;
import com.sakurawald.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemoriesReloadEvent extends Event {
    private Memory memory;
}
