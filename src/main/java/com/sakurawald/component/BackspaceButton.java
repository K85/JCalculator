package com.sakurawald.component;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BackspaceButton extends ApplicationButton{

    public BackspaceButton() {
        super("Backspace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getTextfield_display().getText();
        if (text.isEmpty()) return;
        text = text.substring(0, text.length() - 1);
        getCalculator().getTextfield_display().setText(text);
    }

}
