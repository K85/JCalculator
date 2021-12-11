package com.sakurawald.component;

import lombok.extern.slf4j.Slf4j;

import java.awt.event.ActionEvent;

@Slf4j
public abstract class BinaryOperatorButton extends OperatorButton {

    public BinaryOperatorButton(String text) {
        super(text);
    }

    @Override
    public final void actionPerformed(ActionEvent e) {
        log.debug("operand1 = {}, operator = {}", getCalculator().getOperandFromDisplay(), this);

        // Wait for the last operand ?
        if (getCalculator().getOperands().size() == 1) {
            getCalculator().doEqual();
        }

        // Save Operand 1
        getCalculator().pushOperandFromDisplay();

        // Save Operator
        getCalculator().setOperator(this);
    }


    public double getOperand1() {
        return getCalculator().getOperands().get(0);
    }

    public double getOperand2() {
        return getCalculator().getOperands().get(1);
    }
}


