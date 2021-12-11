package com.sakurawald.component;

import com.sakurawald.event.EventCenter;
import com.sakurawald.event.events.MemoriesClearEvent;
import com.sakurawald.event.events.MemoriesUpdateEvent;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.ActionEvent;

@Slf4j
public class MCButton extends ApplicationButton{

    public MCButton() {
        super("MC");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getCalculator().getMemories().isEmpty()) {
            JOptionPane.showMessageDialog(getCalculator(), "No memory to clear !");
            return;
        }

        // Fire event
        EventCenter.fire(new MemoriesClearEvent(getCalculator().getMemories()));

        // Clear memories
        getCalculator().getMemories().clear();

        // Fire Event
        EventCenter.fire(new MemoriesUpdateEvent(getCalculator().getMemories()));
    }
}
