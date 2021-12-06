package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class SqrtButton extends  ApplicationButton{
    public SqrtButton() {
        super("sqrt");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getTextfield_display().getText();
        text = String.valueOf(Math.sqrt(Double.parseDouble(text)));
        getCalculator().getTextfield_display().setText(text);
    }
}
