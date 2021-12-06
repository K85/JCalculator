package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class InverseButton extends ApplicationButton{
    public InverseButton() {
        super("1/x");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getTextfield_display().getText();
        double value = 1 / Double.parseDouble(text);
        getCalculator().getTextfield_display().setText(String.valueOf(value));
    }
}
