package com.sakurawald.component;

import lombok.extern.slf4j.Slf4j;

import java.awt.event.ActionEvent;

@Slf4j
public class MCButton extends ApplicationButton{

    public MCButton() {
        super("MC");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        log.debug("the size of memories before clear = {}", getCalculator().getMemories().size());
        super.getCalculator().getMemories().clear();
    }
}
