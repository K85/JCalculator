package com.sakurawald.component;

import lombok.extern.slf4j.Slf4j;

import java.awt.event.ActionEvent;

@Slf4j
public abstract class BinaryOperatorButton extends OperatorButton {

    public BinaryOperatorButton(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Save Operand1
        getCalculator().operand1 = Double.parseDouble(getCalculator().getTextfield_display().getText());

        // Set Display Component to empty
        getCalculator().getTextfield_display().setText("");

        // Save Operator
        getCalculator().operator = this;

        log.debug("operand1 = {}, operator = {}", getCalculator().operand1, this);
    }


    public double getOperand1() {
        return getCalculator().operand1;
    }

    public double getOperand2() {
        return Double.parseDouble(getCalculator().getTextfield_display().getText());
    }

}
