package view;

import model.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandardView extends JPanel implements ActionListener {

    private JButton[] keyButton = new JButton[24];
    private Calculator calculator;
    private CalculatorView calculatorView;

    public StandardView(Calculator calculator, CalculatorView calculatorView) {
        this.calculator = calculator;
        this.calculatorView = calculatorView;

        //this.setSize(540, 413);
        //this.setLocation(4, 315);
        //this.setPreferredSize(new Dimension(540, 413));
        this.setLayout(new GridLayout(6, 4, 4, 6));

        addButton();

        this.setBackground(new Color(234, 234, 234));
    }

    private void addButton() {
        String[] buttonIcon = {"%", "CE", "C", "src/image/icon-standard/delete.png", "1/x",
                                "src/image/icon-standard/square2.png", "src/image/icon-standard/squareRoot.png",
                                "src/image/icon-standard/divide.png", "7", "8", "9",
                                "src/image/icon-standard/multiply.png", "4", "5", "6",
                                "src/image/icon-standard/minus.png",
                                "1", "2", "3", "src/image/icon-standard/Plus.png", "mod", "0", "." ,
                                "src/image/icon-standard/Equal.png"};
        for (int i = 0; i < 24; i++) {

            if (i == 3 || i == 5 || i == 6 || i == 7 ||
                i == 11 || i == 15 || i == 19 || i == 23) {

                keyButton[i] = new JButton(new ImageIcon(buttonIcon[i]));
            }
            else {
                keyButton[i] = new JButton(buttonIcon[i]);
                keyButton[i].setFont(new Font("Inter", Font.BOLD, 45));
            }
            keyButton[i].setFocusable(false);
            keyButton[i].setBackground(new Color(199, 199, 199));
            keyButton[i].addActionListener(this);
            this.add(keyButton[i]);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == keyButton[0]) {

        }
        else if (e.getSource() == keyButton[1]) {

        }
        else if (e.getSource() == keyButton[2]) {

        }
        else if (e.getSource() == keyButton[3]) {
            if (calculator.getNumber().length() == 1) {
                calculator.setNumber("0");
            }
            else {
                calculator.setNumber(calculator.getNumber()
                                                .substring(0, calculator.getNumber()
                                                                        .length()-1));
            }
        }
        else if (e.getSource() == keyButton[4]) {

        }
        else if (e.getSource() == keyButton[5]) {

        }
        else if (e.getSource() == keyButton[6]) {

        }
        else if (e.getSource() == keyButton[7]) {

        }
        else if (e.getSource() == keyButton[8]) { // 7
            calculator.setNumber(calculator.getNumber() + "7");

        }
        else if (e.getSource() == keyButton[9]) { // 8
            calculator.setNumber(calculator.getNumber() + "8");

        }
        else if (e.getSource() == keyButton[10]) { // 9
            calculator.setNumber(calculator.getNumber() + "9");

        }
        else if (e.getSource() == keyButton[11]) {

        }
        else if (e.getSource() == keyButton[12]) { // 4
            calculator.setNumber(calculator.getNumber() + "4");

        }
        else if (e.getSource() == keyButton[13]) { // 5
            calculator.setNumber(calculator.getNumber() + "5");

        }
        else if (e.getSource() == keyButton[14]) { // 6
            calculator.setNumber(calculator.getNumber() + "6");

        }
        else if (e.getSource() == keyButton[15]) {

        }
        else if (e.getSource() == keyButton[16]) { // 1
            calculator.setNumber(calculator.getNumber() + "1");

        }
        else if (e.getSource() == keyButton[17]) { // 2
            calculator.setNumber(calculator.getNumber() + "2");

        }
        else if (e.getSource() == keyButton[18]) { // 3
            calculator.setNumber(calculator.getNumber() + "3");

        }
        else if (e.getSource() == keyButton[19]) {

        }
        else if (e.getSource() == keyButton[20]) {

        }
        else if (e.getSource() == keyButton[21]) { // 0
            calculator.setNumber(calculator.getNumber() + "0");
            System.out.println( calculator.getNumber());
        }
        else if (e.getSource() == keyButton[22]) {

        }
        else if (e.getSource() == keyButton[23]) {

        }

        calculatorView.setNumLabel().setText(calculator.getNumber());
    }
}
