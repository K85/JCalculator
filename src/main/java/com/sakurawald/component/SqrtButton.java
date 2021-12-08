package com.sakurawald.component;

public class SqrtButton extends UnaryOperatorButton {
    public SqrtButton() {
        super("sqrt");
    }

    @Override
    public double doCalculate() {
        return Math.sqrt(getOperand());
    }
}
