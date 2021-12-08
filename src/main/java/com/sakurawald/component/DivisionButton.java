package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class DivisionButton extends BinaryOperatorButton {
    public DivisionButton() {
        super("/");
    }

    @Override
    public double doCalculate() {
        return getOperand1() / getOperand2();
    }
}
