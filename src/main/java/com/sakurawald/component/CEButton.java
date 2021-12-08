package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class CEButton extends ApplicationButton{

    public CEButton() {
        super("CE");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getCalculator().clearDisplay();
    }
}
