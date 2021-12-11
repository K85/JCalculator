package com.sakurawald.event.events;

import com.sakurawald.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SetOperandToDisplayEvent extends Event {
    private double oldOperand;
    private double newOperand;
}
