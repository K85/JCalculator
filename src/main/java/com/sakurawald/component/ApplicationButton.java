package com.sakurawald.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ApplicationButton extends JButton implements ActionListener {

    public ApplicationButton(String text) {
        super(text);
        this.addActionListener(this);
    }

    protected Calculator getCalculator() {
        return (Calculator) this.getParent();
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);

}
