package com.sakurawald.component;

import com.sakurawald.bean.History;
import com.sakurawald.bean.Memory;
import com.sakurawald.enums.CalculatorState;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Slf4j
@Data
public class Calculator extends JPanel {
    /* Components */
    private final GridBagConstraints CONSTRAINTS = new GridBagConstraints();
    protected JTextField textfield_display = new JTextField();
    protected JButton button_backspace = new BackspaceButton();
    protected JButton button_CE = new CEButton();
    protected JButton button_C = new CButton();
    protected ArrayList<JButton> buttons;

    /* States */
    protected ArrayList<Memory> memories = new ArrayList<>();
    protected ArrayList<History> histories = new ArrayList<>();
    protected double operand1 = 0;
    protected OperatorButton operator;
    protected CalculatorState state = CalculatorState.WAIT_FOR_OPERAND;

    public Calculator() {
        /* Paint com.sakurawald.bean.Calculator */
        this.setLayout(new GridBagLayout());
        this.textfield_display.setEditable(false);
        addComponentWithGridBagConstraints(textfield_display, 0, 0, 7, 1);
        addComponentWithGridBagConstraints(button_backspace, 1, 1, 2, 1);
        addComponentWithGridBagConstraints(button_CE, 3, 1, 2, 1);
        addComponentWithGridBagConstraints(button_C, 5, 1, 2, 1);
        ArrayList<ApplicationButton> buttons = new ArrayList<>() {
            {
                this.add(new MCButton());
                this.add(new NumberButton(7));
                this.add(new NumberButton(8));
                this.add(new NumberButton(9));
                this.add(new DivisionButton());
                this.add(new SqrtButton());
                this.add(new MRButton());
                this.add(new NumberButton(4));
                this.add(new NumberButton(5));
                this.add(new NumberButton(6));
                this.add(new MultiplicationButton());
                this.add(new ModButton());
                this.add(new MSButton());
                this.add(new NumberButton(1));
                this.add(new NumberButton(2));
                this.add(new NumberButton(3));
                this.add(new SubtractionButton());
                this.add(new InverseButton());
                this.add(new MPlusButton());
                this.add(new NumberButton(0));
                this.add(new SignButton());
                this.add(new RadixPointButton());
                this.add(new AdditionButton());
                this.add(new EqualButton());
            }
        };
        int gridx = 0;
        int gridy = 2;
        for (JButton button : buttons) {
            if (gridx % 6 == 0) {
                gridx = 0;
                gridy++;
            }
            gridx++;
            addComponentWithGridBagConstraints(button, gridx, gridy, 1, 1);
        }
    }

    public void addComponentWithGridBagConstraints(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        CONSTRAINTS.gridx = gridx;
        CONSTRAINTS.gridy = gridy;
        CONSTRAINTS.gridwidth = gridwidth;
        CONSTRAINTS.gridheight = gridheight;
        CONSTRAINTS.fill = GridBagConstraints.HORIZONTAL;
        CONSTRAINTS.insets = new Insets(3, 3, 3, 3);
        this.add(component, CONSTRAINTS);
    }

}
