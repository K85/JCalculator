package com.sakurawald.component;

import com.sakurawald.enums.CalculatorState;

import java.awt.event.ActionEvent;

public class CButton extends ApplicationButton{

    public CButton() {
        super("C");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getCalculator().operand1 = 0;
        getCalculator().operator = null;
        getCalculator().state = CalculatorState.WAIT_FOR_OPERAND_1;
        getCalculator().getTextfield_display().setText("");
    }
}
