package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class EqualButton extends  ApplicationButton{
    public EqualButton() {
        super("=");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Post-Eval Expression
        OperatorButton operatorButton = getCalculator().getOperator();
        double value = operatorButton.postCalculate();

        // Update the display
        getCalculator().getTextfield_display().setText(String.valueOf(value));
    }
}
