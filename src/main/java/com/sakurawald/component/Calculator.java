package com.sakurawald.component;

import com.sakurawald.bean.History;
import com.sakurawald.bean.Memory;
import com.sakurawald.event.EventCenter;
import com.sakurawald.event.Listener;
import com.sakurawald.event.events.*;
import lombok.Getter;
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
    private final ArrayList<Double> operands = new ArrayList<>();
    @Getter
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

        /* Register Events */
        EventCenter.register(new Listener<RequestChangeDisplayEvent>() {
            @Override
            public void onEvent(RequestChangeDisplayEvent event) {
                if (event.isCancelled()) return;
                getDisplay().setText(event.getNewDisplay());
            }
        });
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
        /* Get operand from display */
        double operand;
        try {
            operand = getOperandFromDisplay();
        } catch (Exception e) {
            return;
        }

        /* Fire event */
        var event = new PushOperandEvent(operand);
        EventCenter.fire(event);

        /* Push operand to operands */
        this.operands.add(event.getOperand());
        this.clearDisplay();
    }

    public double getOperandFromDisplay() {
        try {
            return Double.parseDouble(this.display.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error Input Number !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            // Re-throw the exception to stop the following instructions.
            throw e;
        }
    }

    public void setOperandToDisplay(double operand) {
        var event = new SetOperandToDisplayEvent(getOperandFromDisplay(), operand);
        EventCenter.fire(event);
        this.display.setText(String.valueOf(event.getNewOperand()));
    }

    public void clearDisplay() {
        EventCenter.fire(new ClearDisplayEvent(this.display.getText()));
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
        double value = this.getOperator().doCalculate();

        // Fire -> HistorySpawnEvent
        History history = new History(new ArrayList<>(getOperands()), getOperator().toString(), value);
        EventCenter.fire(new HistorySpawnEvent(history));

        // Update the display
        this.setOperandToDisplay(value);

        // Clear the expression
        this.clearOperands();
        this.clearOperator();
    }

    public void clearOperator() {
        this.setOperator(null);
    }

    public void setOperator(OperatorButton operator) {
        var event = new SetOperatorEvent(this.operator, operator);
        EventCenter.fire(event);
        this.operator = event.getNewOperator();
    }

    public void clearOperands() {
        EventCenter.fire(new ClearOperandsEvent(this.getOperands()));
        this.getOperands().clear();
    }

}
