package com.sakurawald;

import com.sakurawald.component.Calculator;
import com.sakurawald.component.extension.AuxiliaryDisplayExtension;
import com.sakurawald.component.extension.HistoryExtension;
import com.sakurawald.component.extension.MemoriesExtension;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Slf4j
public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        /* Add Components */
        frame.add(new JPanel() {
            {
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                this.add(new MemoriesExtension());
                this.add(new AuxiliaryDisplayExtension());
                this.add(new Calculator());
            }
        });
        frame.add(new HistoryExtension());

        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(500, 300));
        frame.setIconImage(ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("icon.png"))));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}