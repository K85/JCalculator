package com.sakurawald.component;

import com.sakurawald.bean.Memory;
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
        log.debug("store memory: {}", value);
        this.getCalculator().getMemories().add(new Memory(value));
    }
}
