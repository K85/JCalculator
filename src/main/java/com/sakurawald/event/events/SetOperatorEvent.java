package com.sakurawald.event.events;

import com.sakurawald.component.OperatorButton;
import com.sakurawald.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SetOperatorEvent extends Event {
    private OperatorButton oldOperator;
    private OperatorButton newOperator;
}
