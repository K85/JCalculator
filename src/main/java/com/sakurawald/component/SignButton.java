package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class SignButton extends ApplicationButton{
    public SignButton() {
        super("+/-");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getTextfield_display().getText();
        if (text.isEmpty()) return;
        else if (text.charAt(0) == '+') return;
        else if (text.charAt(0) == '-') text = text.substring(1, text.length());
        else text = "-" + text;
        getCalculator().getTextfield_display().setText(text);
    }
}
