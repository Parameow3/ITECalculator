package view;

import model.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView extends JPanel implements ActionListener { // calculator Pane
    private JLabel displayLabel;
    private JPanel keyPanel;
    private JPanel standardKeyPad;
    private JPanel displayPanel;
    private JButton[] keyButton = new JButton[24];

    private CardLayout cardLayout;

    private String number = "0";
    private Calculator calculator = new Calculator();

    // constructor
    public CalculatorView(){

        // number label
        displayLabel = new JLabel(number, JLabel.RIGHT);

        // keypad panel
        keyPanel = new JPanel();

        // Card Layout for keyPanel
        cardLayout = new CardLayout();

        // keypad in keyPanel
        standardKeyPad = new JPanel();

        // method in class
        customizeView();
    }

    private void customizeView() {
        // customize Calculator panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // customize display label
        displayLabel.setFont(new Font("Itim", Font.BOLD, 60));

        // customize keyPanel
        keyPanel.setLayout(cardLayout);
        keyPanel.add(standardKeyPad);

        // customize keyPad Panel
        standardKeyPad.setLayout(new GridLayout(6, 4, 4, 6));
        addButton();

        // add component to Calculator panel
        this.add(displayLabel);
        this.add(keyPanel);
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
                keyButton[i].setFont(new Font("Inter", Font.BOLD, 20));
            }
            keyButton[i].setFocusable(false);
            keyButton[i].setBackground(new Color(199, 199, 199));
            keyButton[i].addActionListener(this);
            standardKeyPad.add(keyButton[i]);
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
                this.setNumLabel(calculator.getNumber());
            }
            else {
                calculator.setNumber(calculator.getNumber()
                        .substring(0, calculator.getNumber()
                                .length()-1));
                this.setNumLabel(calculator.getNumber());
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
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("7");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "7");
            }
        }
        else if (e.getSource() == keyButton[9]) { // 8
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("8");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "8");
            }
        }
        else if (e.getSource() == keyButton[10]) { // 9
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("9");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "9");
            }

        }
        else if (e.getSource() == keyButton[11]) {

        }
        else if (e.getSource() == keyButton[12]) { // 4
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("4");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "4");
            }
        }
        else if (e.getSource() == keyButton[13]) { // 5
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("5");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "5");
            }

        }
        else if (e.getSource() == keyButton[14]) { // 6
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("6");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "6");
            }
        }
        else if (e.getSource() == keyButton[15]) {

        }
        else if (e.getSource() == keyButton[16]) { // 1
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("1");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "1");
            }

        }
        else if (e.getSource() == keyButton[17]) { // 2
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("2");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "2");
            }

        }
        else if (e.getSource() == keyButton[18]) { // 3
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("3");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "3");
            }

        }
        else if (e.getSource() == keyButton[19]) {

        }
        else if (e.getSource() == keyButton[20]) {

        }
        else if (e.getSource() == keyButton[21]) { // 0
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("0");
            }
            else {
                this.setNumLabel(calculator.getNumber() + "0");
            }
        }
        else if (e.getSource() == keyButton[22]) {

        }
        else if (e.getSource() == keyButton[23]) {

        }
    }

    private void setNumLabel(String num) {

        this.number = num;
        calculator.setNumber(number);
        displayLabel.setText(number);
    }
}
