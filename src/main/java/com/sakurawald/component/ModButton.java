package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class ModButton extends BinaryOperatorButton{
    public ModButton() {
        super("%");
    }

    @Override
    public double postCalculate() {
        return getOperand1() % getOperand2();
    }
}
