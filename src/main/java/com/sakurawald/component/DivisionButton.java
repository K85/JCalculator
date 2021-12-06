package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class DivisionButton extends BinaryOperatorButton {
    public DivisionButton() {
        super("/");
    }

    @Override
    public double postCalculate() {
        return getOperand1() / getOperand2();
    }
}
