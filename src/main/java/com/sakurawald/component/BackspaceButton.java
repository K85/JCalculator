package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class BackspaceButton extends ApplicationButton {

    public BackspaceButton() {
        super("Backspace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getDisplay().getText();
        getCalculator().getDisplay().setText(text.substring(0, text.length() - 1));
        if (getCalculator().getDisplay().getText().isEmpty()) {
            getCalculator().getDisplay().setText(getCalculator().DEFAULT_DISPLAY_TEXT);
        }
    }

}
