package com.sakurawald.event.events;

import com.sakurawald.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ClearOperandsEvent extends Event {
    private ArrayList<Double> oldOperands;

}
