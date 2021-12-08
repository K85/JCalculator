package com.sakurawald.component;

import java.awt.*;

public abstract class OperatorButton extends ApplicationButton {

    public OperatorButton(String text) {
        super(text);
    }

    public abstract double doCalculate();

    @Override
    public String toString() {
        return this.getText();
    }

}
