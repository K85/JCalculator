package com.sakurawald.event.events;

import com.sakurawald.bean.Memory;
import com.sakurawald.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class MemoriesUpdateEvent extends Event {
    private ArrayList<Memory> memories;
}
