package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class SignButton extends ApplicationButton{
    public SignButton() {
        super("+/-");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getDisplay().getText();
        if (text.isEmpty()) return;
        else if (text.charAt(0) == '0') return;
        else if (text.charAt(0) == '+') return;
        else if (text.charAt(0) == '-') text = text.substring(1);
        else text = "-" + text;
        getCalculator().getDisplay().setText(text);
    }
}
