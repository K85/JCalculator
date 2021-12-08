package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class CButton extends ApplicationButton{

    public CButton() {
        super("C");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getCalculator().getOperands().clear();
        getCalculator().setOperator(null);
        getCalculator().clearDisplay();
    }
}
