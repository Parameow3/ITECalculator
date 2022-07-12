package view;

import model.Calculator;

import javax.swing.*;
import java.awt.*;

public class MainWindowView extends JFrame {


    public MainWindowView() {

        this.setSize(562, 768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Calculator calculator = new Calculator();
        CalculatorView calculatorView = new CalculatorView(calculator);

        this.getContentPane().add(new CalculatorView(calculator), BorderLayout.PAGE_START);
        this.getContentPane().add(new StandardView(calculator, calculatorView), BorderLayout.CENTER);

        this.setBackground(new Color(234, 234, 234));
        this.setVisible(true);
    }
}
