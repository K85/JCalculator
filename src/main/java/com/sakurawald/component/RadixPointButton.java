package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class RadixPointButton extends  ApplicationButton{
    public RadixPointButton() {
        super(".");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getDisplay().getText();
        if (text.indexOf('.') != -1) return;
        text = text + ".";
        getCalculator().getDisplay().setText(text);
    }
}
