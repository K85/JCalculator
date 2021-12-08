package com.sakurawald.component;

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
        log.debug("the size of memories before clear = {}", getCalculator().getMemories().size());
        super.getCalculator().getMemories().clear();
    }
}
