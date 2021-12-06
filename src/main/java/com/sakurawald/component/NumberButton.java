package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class NumberButton extends ApplicationButton{

    public NumberButton(int digit) {
        super(String.valueOf(digit));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getTextfield_display().getText();
        text = text + this.getText();
        getCalculator().getTextfield_display().setText(text);
    }
}
