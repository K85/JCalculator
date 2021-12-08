package com.sakurawald.component;

import lombok.extern.slf4j.Slf4j;

import java.awt.event.ActionEvent;

@Slf4j
public abstract class UnaryOperatorButton extends OperatorButton {

    public UnaryOperatorButton(String text) {
        super(text);
    }

    @Override
    public final void actionPerformed(ActionEvent e) {
        log.debug("operand1 = {}, operator = {}", getCalculator().getOperandFromDisplay(), this);

        // Save Operator
        getCalculator().setOperator(this);

        // Do equal
        getCalculator().doEqual();
    }

    public double getOperand() {
        return getCalculator().getOperands().get(0);
    }

}
