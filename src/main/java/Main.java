import com.sakurawald.component.Calculator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");

        frame.add(new Calculator());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
