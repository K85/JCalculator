package com.sakurawald.component.extension;

import com.sakurawald.event.EventCenter;
import com.sakurawald.event.Listener;
import com.sakurawald.event.events.ClearOperandsEvent;
import com.sakurawald.event.events.PushOperandEvent;
import com.sakurawald.event.events.SetOperatorEvent;

import javax.swing.*;
import java.awt.*;

public class AuxiliaryDisplayExtension extends JPanel {

    private final String DEFAULT_NONE_TEXT = "None";
    private final String DEFAULT_EMPTY_TEXT = "";
    private final JLabel auxiliaryDisplay = new JLabel(DEFAULT_NONE_TEXT);

    public AuxiliaryDisplayExtension() {

        /* Add Components */
        this.add(auxiliaryDisplay);

        /* Register Events */
        EventCenter.register(new Listener<PushOperandEvent>() {
            @Override
            public void onEvent(PushOperandEvent event) {
                appendAuxiliaryDisplay(String.valueOf(event.getOperand()));
            }
        });

        EventCenter.register(new Listener<SetOperatorEvent>() {
            @Override
            public void onEvent(SetOperatorEvent event) {
                if (event.getNewOperator() == null) return;
                appendAuxiliaryDisplay(" " + event.getNewOperator());
            }
        });

        EventCenter.register(new Listener<ClearOperandsEvent>() {
            @Override
            public void onEvent(ClearOperandsEvent event) {
                auxiliaryDisplay.setText(DEFAULT_NONE_TEXT);
            }
        });
    }

    private void appendAuxiliaryDisplay(String appendText) {
        if (auxiliaryDisplay.getText().equals(DEFAULT_NONE_TEXT)) {
            auxiliaryDisplay.setText(DEFAULT_EMPTY_TEXT);
        }
        String text = auxiliaryDisplay.getText();
        text += appendText;
        auxiliaryDisplay.setText(text);
    }
}
