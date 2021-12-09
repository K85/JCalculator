package com.sakurawald.component;

import com.sakurawald.extension.History;
import com.sakurawald.extension.Memory;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Slf4j
public class Calculator extends JPanel {
    /* Components */
    private final GridBagConstraints CONSTRAINTS = new GridBagConstraints();
    protected final String DEFAULT_DISPLAY_TEXT = "0";

    @Getter
    private final JTextField display = new JTextField(DEFAULT_DISPLAY_TEXT);

    /* States */
    @Getter
    private final ArrayList<Memory> memories = new ArrayList<>();
    @Getter
    private final ArrayList<History> histories = new ArrayList<>();
    @Getter
    private final ArrayList<Double> operands = new ArrayList<>();
    @Getter
    @Setter
    private OperatorButton operator;

    public Calculator() {
        /* Paint Calculator */
        this.setLayout(new GridBagLayout());
        this.display.setEditable(false);
        addComponentWithGridBagConstraints(display, 0, 0, 7, 1);
        addComponentWithGridBagConstraints(new BackspaceButton(), 1, 1, 2, 1);
        addComponentWithGridBagConstraints(new CEButton(), 3, 1, 2, 1);
        addComponentWithGridBagConstraints(new CButton(), 5, 1, 2, 1);
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

    private void addComponentWithGridBagConstraints(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        CONSTRAINTS.gridx = gridx;
        CONSTRAINTS.gridy = gridy;
        CONSTRAINTS.gridwidth = gridwidth;
        CONSTRAINTS.gridheight = gridheight;
        CONSTRAINTS.fill = GridBagConstraints.HORIZONTAL;
        CONSTRAINTS.insets = new Insets(3, 3, 3, 3);
        this.add(component, CONSTRAINTS);
    }


    public void pushOperandFromDisplay() {
        this.operands.add(getOperandFromDisplay());
        this.clearDisplay();
    }

    public double getOperandFromDisplay() {
        return Double.parseDouble(this.display.getText());
    }

    public void setOperandToDisplay(double operand) {
        this.display.setText(String.valueOf(operand));
    }

    public void clearDisplay() {
        this.display.setText(DEFAULT_DISPLAY_TEXT);
    }

    public void doEqual() {

        // Expression's Reflexivity
        if (getOperator() == null) {
            return;
        }

        // Push current display value as the last operand
        this.pushOperandFromDisplay();
        log.debug("operator = {}, operands = {}", operator, operands);

        // Eval the expression
        double value = getOperator().doCalculate();

        // Update the display
        this.setOperandToDisplay(value);

        // Clear the expression
        this.getOperands().clear();
        this.setOperator(null);
    }

}
