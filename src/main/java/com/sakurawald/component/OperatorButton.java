package com.sakurawald.component;

import java.awt.event.ActionEvent;

public abstract class OperatorButton extends ApplicationButton {

    public OperatorButton(String text) {
        super(text);
    }

    public abstract double postCalculate();

    @Override
    public String toString() {
        return this.getText();
    }

}
