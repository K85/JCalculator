package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class SubtractionButton extends  BinaryOperatorButton{
    public SubtractionButton() {
        super("-");
    }

    @Override
    public double postCalculate() {
        return getOperand1() - getOperand2();
    }
}
