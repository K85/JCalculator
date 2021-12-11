package com.sakurawald.component;

import com.sakurawald.bean.Memory;
import com.sakurawald.event.Event;
import com.sakurawald.event.EventCenter;
import com.sakurawald.event.events.MemoriesPlusEvent;
import com.sakurawald.event.events.MemoriesUpdateEvent;
import lombok.extern.slf4j.Slf4j;

import java.awt.event.ActionEvent;

@Slf4j
public class MPlusButton extends ApplicationButton {

    public MPlusButton() {
        super("M+");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getCalculator().getMemories().isEmpty()) return;
        double operand1 = getCalculator().getMemories().get(getCalculator().getMemories().size() - 1).getValue();
        double operand2 = getCalculator().getOperandFromDisplay();
        double value = operand1 + operand2;

        // Fire Event
        Memory memory = new Memory(value);
        EventCenter.fire(new MemoriesPlusEvent(memory));

        // Memories Plus
        log.debug("operand1 = {}, operand2 = {}, value = {}", operand1, operand2, value);
        getCalculator().getMemories().add(memory);

        // Fire Event
        EventCenter.fire(new MemoriesUpdateEvent(getCalculator().getMemories()));
    }
}
