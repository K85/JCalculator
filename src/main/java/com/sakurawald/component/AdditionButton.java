package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class AdditionButton extends BinaryOperatorButton{
    public AdditionButton() {
        super("+");
    }

    @Override
    public double doCalculate() {
        return getOperand1() + getOperand2();
    }

}
