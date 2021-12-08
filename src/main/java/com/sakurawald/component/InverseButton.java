package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class InverseButton extends UnaryOperatorButton {
    public InverseButton() {
        super("1/x");
    }

    @Override
    public double doCalculate() {
        return  1 / getOperand();
    }
}
