package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class MultiplicationButton extends BinaryOperatorButton{
    public MultiplicationButton() {
        super("*");
    }

    @Override
    public double doCalculate() {
        return getOperand1() * getOperand2();
    }
}
