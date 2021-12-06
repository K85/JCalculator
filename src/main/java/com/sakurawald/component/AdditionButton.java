package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class AdditionButton extends BinaryOperatorButton{
    public AdditionButton() {
        super("+");
    }

    @Override
    public double postCalculate() {
        return getOperand1() + getOperand2();
    }

}
