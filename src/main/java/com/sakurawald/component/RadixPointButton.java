package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class RadixPointButton extends  ApplicationButton{
    public RadixPointButton() {
        super(".");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getTextfield_display().getText();
        text = text + ".";
        getCalculator().getTextfield_display().setText(text);
    }
}
