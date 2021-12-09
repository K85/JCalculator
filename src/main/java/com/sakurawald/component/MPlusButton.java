package com.sakurawald.component;

import com.sakurawald.extension.Memory;
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
        double operand2 = Double.parseDouble(getCalculator().getDisplay().getText());
        double value = operand1 + operand2;
        log.debug("operand1 = {}, operand2 = {}, value = {}", operand1, operand2, value);
        getCalculator().getMemories().add(new Memory(value));
    }
}
