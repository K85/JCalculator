package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class EqualButton extends ApplicationButton{
    public EqualButton() {
        super("=");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // EqualButton is not an UnaryOperatorButton, just call Calculator.doEqual()
        getCalculator().doEqual();
    }
}
