package com.sakurawald.component;

import com.sakurawald.bean.Memory;

import java.awt.event.ActionEvent;

public class MPlusButton extends ApplicationButton{

    public MPlusButton() {
        super("M+");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getCalculator().getMemories().isEmpty()) return;
        double operand1 = getCalculator().getMemories().get(getCalculator().getMemories().size() - 1).getValue();
        double operand2 = Double.parseDouble(getCalculator().getTextfield_display().getText());
        double value = operand1 + operand2;
        getCalculator().getMemories().add(new Memory(value));
    }
}
