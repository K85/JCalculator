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
        String text = this.getCalculator().getTextfield_display().getText();
        log.debug("store memory: {}", text);
        this.getCalculator().getMemories().add(new Memory(Double.parseDouble(text)));
    }
}
