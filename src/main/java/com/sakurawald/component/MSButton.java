package com.sakurawald.component;

import com.sakurawald.event.EventCenter;
import com.sakurawald.event.events.MemoriesStoreEvent;
import com.sakurawald.bean.Memory;
import com.sakurawald.event.events.MemoriesUpdateEvent;
import lombok.extern.slf4j.Slf4j;

import java.awt.event.ActionEvent;

@Slf4j
public class MSButton extends ApplicationButton{

    public MSButton() {
        super("MS");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double value = getCalculator().getOperandFromDisplay();
        Memory memory = new Memory(value);

        // Fire event
        EventCenter.fire(new MemoriesStoreEvent(memory));

        // Store memory
        log.debug("store memory: {}", value);
        this.getCalculator().getMemories().add(memory);

        // Fire Event
        EventCenter.fire(new MemoriesUpdateEvent(getCalculator().getMemories()));
    }
}
