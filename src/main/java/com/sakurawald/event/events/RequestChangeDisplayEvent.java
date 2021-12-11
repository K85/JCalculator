package com.sakurawald.event.events;

import com.sakurawald.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestChangeDisplayEvent extends Event {
    private String newDisplay;
}
