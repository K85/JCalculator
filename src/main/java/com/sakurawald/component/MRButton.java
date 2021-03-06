package com.sakurawald.component;

import com.sakurawald.event.EventCenter;
import com.sakurawald.event.events.MemoriesReloadEvent;
import com.sakurawald.bean.Memory;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.ActionEvent;

@Slf4j
public class MRButton extends ApplicationButton{

    public MRButton() {
        super("MR");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (super.getCalculator().getMemories().isEmpty()) {
            JOptionPane.showMessageDialog(getCalculator(), "No memory to load !");
            return;
        }

        Memory latestMemory = super.getCalculator().getMemories().get(super.getCalculator().getMemories().size() - 1);

        // Fire Event
        EventCenter.fire(new MemoriesReloadEvent(latestMemory));

        // Reload Memory
        getCalculator().setOperandToDisplay(latestMemory.getValue());
    }
}
