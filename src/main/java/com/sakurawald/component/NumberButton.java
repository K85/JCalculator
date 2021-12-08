package com.sakurawald.component;

import java.awt.event.ActionEvent;

public class NumberButton extends ApplicationButton{

    public NumberButton(int digit) {
        super(String.valueOf(digit));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = getCalculator().getDisplay().getText();
        // Keep the display always shows DISPLAY_DEFAULT_TEXT when the text is empty.
        if (text.equals(getCalculator().DEFAULT_DISPLAY_TEXT))  {
            text = "";
        }
        text = text + this.getText();
        getCalculator().getDisplay().setText(text);
    }
}
