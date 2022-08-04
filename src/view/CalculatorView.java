package view;

import model.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView extends JPanel implements ActionListener { // calculator Pane

    private JLabel displayLabel;
    private JPanel displayPanel;

    private JPanel keyPanel;
    private JPanel standardKeyPad;
    private JPanel scientificPanel;

    private JButton[] keyButtonStandard = new JButton[24];
    private JButton[] keyButtonScientific = new JButton[30];

    private CardLayout cardLayout;

    private String number = "0";
    private Calculator calculator = new Calculator();

    // constructor
    public CalculatorView(){

        // number label
        displayLabel = new JLabel(number);

        // keypad panel
        keyPanel = new JPanel();

        // Card Layout for keyPanel
        cardLayout = new CardLayout();

        // standard keypad in keyPanel
        standardKeyPad = new JPanel();

        // scientific keypad in keyPanel
        scientificPanel = new JPanel();

        // display panel
        displayPanel = new JPanel();

        // method in class
        customizeView();
    }

    private void customizeView() {
        // customize Calculator panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // customize display label
        displayLabel.setFont(new Font("Itim", Font.BOLD, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);

        displayPanel.add(displayLabel, LEFT_ALIGNMENT);
        displayPanel.setBackground(Color.ORANGE);

        // customize keyPanel
        keyPanel.setLayout(cardLayout);
        keyPanel.add(standardKeyPad);
        //keyPanel.add(scientificPanel);

        // customize standard keyPad Panel
        standardKeyPad.setLayout(new GridLayout(6, 4, 4, 6));
        addButtonStandard();

        // customize scientific keyPad Panel
        scientificPanel.setLayout(new GridLayout(6, 5, 2, 2));
        addButtonScientific();

        // add component to Calculator panel
        this.add(displayPanel);
        this.add(keyPanel);
    }

    private void addButtonStandard() {
        String[] buttonIconStandard = {"%", "CE", "C", "src/image/icon-standard/delete.png", "1/x",
                "src/image/icon-standard/square2.png", "src/image/icon-standard/squareRoot.png",
                "src/image/icon-standard/divide.png", "7", "8", "9",
                "src/image/icon-standard/multiply.png", "4", "5", "6",
                "src/image/icon-standard/minus.png",
                "1", "2", "3", "src/image/icon-standard/Plus.png", "mod", "0", "." ,
                "src/image/icon-standard/Equal.png"};
        for (int i = 0; i < 24; i++) {

            if (i == 3 || i == 5 || i == 6 || i == 7 ||
                    i == 11 || i == 15 || i == 19 || i == 23) {

                keyButtonStandard[i] = new JButton(new ImageIcon(buttonIconStandard[i]));
            }
            else {
                keyButtonStandard[i] = new JButton(buttonIconStandard[i]);
                keyButtonStandard[i].setFont(new Font("Inter", Font.BOLD, 25));
            }
            keyButtonStandard[i].setFocusable(false);
            keyButtonStandard[i].setBackground(new Color(199, 199, 199));
            keyButtonStandard[i].addActionListener(this);
            standardKeyPad.add(keyButtonStandard[i]);
        }
    }

    private void addButtonScientific() {
        String[] buttonIcon = {"(", ")", "CE", "C", "src/image/icon-scientific/delete-small.png",
                "n!", "sin", "cos", "tan", "src/image/icon-scientific/divide-small.png",
                "src/image/icon-scientific/pi.png", "7", "8", "9",
                "src/image/icon-scientific/multiply-small.png",
                "src/image/icon-scientific/square-root-small.png", "4", "5", "6",
                "src/image/icon-scientific/minus-small.png",
                "src/image/icon-scientific/square2-small.png", "1", "2", "3",
                "src/image/icon-scientific/plus-small.png", "DEG", "%", "0", ".",
                "src/image/icon-scientific/Equal-small.png"};
        for (int i = 0; i < 30; i++) {


            if ( i == 4 || i == 9 || i == 10 || i == 14
                || i == 15 || i == 19 || i == 20 || i == 24 || i == 29) {

                keyButtonScientific[i] = new JButton(new ImageIcon(buttonIcon[i]));
            } else {
                keyButtonScientific[i] = new JButton(buttonIcon[i]);
                keyButtonScientific[i].setFont(new Font("Inter", Font.BOLD, 24));
            }

            if (i == 25)
                keyButtonScientific[i].setFont(new Font("Inter", Font.BOLD, 15));
            keyButtonScientific[i].setFocusable(false);
            keyButtonScientific[i].setBackground(new Color(199, 199, 199));
            keyButtonScientific[i].addActionListener(this);
            scientificPanel.add(keyButtonScientific[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // standard button action listener
        if (e.getSource() == keyButtonStandard[0]) {

        } else if (e.getSource() == keyButtonStandard[1]) {

        } else if (e.getSource() == keyButtonStandard[2]) {

        } else if (e.getSource() == keyButtonStandard[3]) {
            if (calculator.getNumber().length() == 1) {
                    calculator.setNumber("0");
                    this.setNumLabel(calculator.getNumber());
            } else {
                calculator.setNumber(calculator.getNumber()
                            .substring(0, calculator.getNumber()
                                    .length() - 1));
                    this.setNumLabel(calculator.getNumber());
            }
        } else if (e.getSource() == keyButtonStandard[4]) {

        } else if (e.getSource() == keyButtonStandard[5]) {

        } else if (e.getSource() == keyButtonStandard[6]) {

        } else if (e.getSource() == keyButtonStandard[7]) {

        } else if (e.getSource() == keyButtonStandard[8]) { // 7
            if (calculator.getNumber().equals("0")) {
                    this.setNumLabel("7");
            } else {
                this.setNumLabel(calculator.getNumber() + "7");
            }
        } else if (e.getSource() == keyButtonStandard[9]) { // 8
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("8");
            } else {
                    this.setNumLabel(calculator.getNumber() + "8");
            }
        } else if (e.getSource() == keyButtonStandard[10]) { // 9
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("9");
            } else {
                this.setNumLabel(calculator.getNumber() + "9");
            }

        } else if (e.getSource() == keyButtonStandard[11]) {

        } else if (e.getSource() == keyButtonStandard[12]) { // 4
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("4");
            } else {
                this.setNumLabel(calculator.getNumber() + "4");
            }
        } else if (e.getSource() == keyButtonStandard[13]) { // 5
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("5");
            } else {
                this.setNumLabel(calculator.getNumber() + "5");
            }

        } else if (e.getSource() == keyButtonStandard[14]) { // 6
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("6");
            } else {
                this.setNumLabel(calculator.getNumber() + "6");
            }
        } else if (e.getSource() == keyButtonStandard[15]) {

        } else if (e.getSource() == keyButtonStandard[16]) { // 1
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("1");
            } else {
                this.setNumLabel(calculator.getNumber() + "1");
            }

        } else if (e.getSource() == keyButtonStandard[17]) { // 2
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("2");
            } else {
                this.setNumLabel(calculator.getNumber() + "2");
            }

        } else if (e.getSource() == keyButtonStandard[18]) { // 3
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("3");
            } else {
                this.setNumLabel(calculator.getNumber() + "3");
            }
         } else if (e.getSource() == keyButtonStandard[19]) {

        } else if (e.getSource() == keyButtonStandard[20]) {

        } else if (e.getSource() == keyButtonStandard[21]) { // 0
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("0");
            } else {
                this.setNumLabel(calculator.getNumber() + "0");
            }
        } else if (e.getSource() == keyButtonStandard[22]) {

        } else if (e.getSource() == keyButtonStandard[23]) {

        }
        // ------------------------------------------------------

        // scientific button action listener
        if (e.getSource() == keyButtonScientific[0]){
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("(");
            } else {
                this.setNumLabel(calculator.getNumber() + "(");
            }
        } else if (e.getSource() == keyButtonScientific[1]) {
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel(")");
            } else {
                this.setNumLabel(calculator.getNumber() + ")");
            }
        } else if (e.getSource() == keyButtonScientific[2]) {

        } else if (e.getSource() == keyButtonScientific[3]) {

        } else if (e.getSource() == keyButtonScientific[4]) {
            if (calculator.getNumber().length() == 1) {
                calculator.setNumber("0");
                this.setNumLabel(calculator.getNumber());
            } else {
                calculator.setNumber(calculator.getNumber()
                        .substring(0, calculator.getNumber()
                                .length() - 1));
                this.setNumLabel(calculator.getNumber());
            }
        } else if (e.getSource() == keyButtonScientific[5]) {

        } else if (e.getSource() == keyButtonScientific[6]) {

        } else if (e.getSource() == keyButtonScientific[7]) {

        } else if (e.getSource() == keyButtonScientific[8]) {

        } else if (e.getSource() == keyButtonScientific[9]) {

        } else if (e.getSource() == keyButtonScientific[10]) {

        } else if (e.getSource() == keyButtonScientific[11]) { // 7
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("7");
            } else {
                this.setNumLabel(calculator.getNumber() + "7");
            }
        } else if (e.getSource() == keyButtonScientific[12]) { // 8
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("8");
            } else {
                this.setNumLabel(calculator.getNumber() + "8");
            }
        } else if (e.getSource() == keyButtonScientific[13]) { // 9
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("9");
            } else {
                this.setNumLabel(calculator.getNumber() + "9");
            }

        } else if (e.getSource() == keyButtonScientific[14]) {

        } else if (e.getSource() == keyButtonScientific[15]) {

        } else if (e.getSource() == keyButtonScientific[16]) { // 4

            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("4");
            } else {
                this.setNumLabel(calculator.getNumber() + "4");
            }
        } else if (e.getSource() == keyButtonScientific[17]) { // 5
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("5");
            } else {
                this.setNumLabel(calculator.getNumber() + "5");
            }
        } else if (e.getSource() == keyButtonScientific[18]) { // 6
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("6");
            } else {
                this.setNumLabel(calculator.getNumber() + "6");
            }
        } else if (e.getSource() == keyButtonScientific[19]) {

        } else if (e.getSource() == keyButtonScientific[20]) {

        } else if (e.getSource() == keyButtonScientific[21]) { // 1
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("1");
            } else {
                this.setNumLabel(calculator.getNumber() + "1");
            }

        } else if (e.getSource() == keyButtonScientific[22]) { // 2
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("2");
            } else {
                this.setNumLabel(calculator.getNumber() + "2");
            }
        } else if (e.getSource() == keyButtonScientific[23]) { // 3
            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("3");
            } else {
                this.setNumLabel(calculator.getNumber() + "3");
            }
        } else if (e.getSource() == keyButtonScientific[24]) {

        } else if (e.getSource() == keyButtonScientific[25]) {

        } else if (e.getSource() == keyButtonScientific[26]) {

        } else if (e.getSource() == keyButtonScientific[27]) { // 0

            if (calculator.getNumber().equals("0")) {
                this.setNumLabel("0");
            } else {
                this.setNumLabel(calculator.getNumber() + "0");
            }
        } else if (e.getSource() == keyButtonScientific[28]) {

        } else if (e.getSource() == keyButtonScientific[29]) {

        }
    }

    private void setNumLabel(String num) {

        this.number = num;
        calculator.setNumber(number);
        displayLabel.setText(number);
    }

}
