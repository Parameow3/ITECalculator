package view;

import Algorithm.Arithmetic;
import Algorithm.Trigonometry;
import model.Calculator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandardView extends JPanel implements ActionListener {

    private GridBagConstraints c;
    private JButton[] keyButtonStandard = new JButton[24];
    private JLabel displayLabel;
    private JLabel historyLabel;
    private JPanel displayPanel;

    private Border etchedBorder;

    private Calculator calculator;
    private Trigonometry trigonometry;
    private Arithmetic arithmetic;

    private int gx = 0,gy = 1;

    private boolean operator;
    private int method;
    private boolean dot;

    public StandardView() {

        this.setLayout(new GridBagLayout());

        // initiate object
        calculator = new Calculator();
        trigonometry = new Trigonometry();
        arithmetic = new Arithmetic();
        displayLabel = new JLabel(calculator.getNumber1());
        historyLabel = new JLabel(" ");

        c = new GridBagConstraints();
        etchedBorder = new EtchedBorder();

        displayLabel.setFont(new Font("Itim", Font.BOLD, 55));
        displayLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 5, Color.LIGHT_GRAY));
        displayLabel.setPreferredSize(new Dimension(displayLabel.getWidth(), 65));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);

        historyLabel.setFont(new Font("Itim", Font.PLAIN, 25));
        historyLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.LIGHT_GRAY));
        historyLabel.setHorizontalAlignment(JLabel.RIGHT);

        displayPanel = new JPanel(new BorderLayout());
        displayPanel.add(historyLabel, BorderLayout.PAGE_START);
        displayPanel.add(displayLabel, BorderLayout.CENTER);

        // customize constraint for label
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(displayPanel, c);
        createKey();
    }

    private void createKey() { // src/image/icon-standard/Plus.png    || i == 15 || i == 19
        String[] buttonIconStandard = {"%", "CE", "C", "src/image/icon-scientific/delete-small.png", "1/x",
                "<html>X<sup>2</sup></html>", "√x",
                "src/image/icon-scientific/divide-small.png", "7", "8", "9", "src/image/icon-scientific/multiply-small.png", "4", "5", "6",
                "src/image/icon-scientific/minus-small.png", "1", "2", "3", "src/image/icon-scientific/plus-small.png", "mod", "0", "." ,
                "src/image/equals.gif"};
        for (int i = 0; i < 24; i++) {

            if (i == 3 || i == 7 || i == 11 || i == 15
                    || i == 19 || i == 23) {

                keyButtonStandard[i] = new JButton(new ImageIcon(buttonIconStandard[i]));
            }
            else {
                keyButtonStandard[i] = new JButton(buttonIconStandard[i]);
                keyButtonStandard[i].setFont(new Font("Itim", Font.PLAIN, 35));
            }
            if (i == 4 || i == 20 || i == 6 || i == 5)
                keyButtonStandard[i].setFont(new Font("Itim", Font.PLAIN, 25));
            keyButtonStandard[i].setFocusable(false);
            keyButtonStandard[i].setBackground(new Color(199, 199, 199));
            keyButtonStandard[i].addActionListener(this);

            keyButtonStandard[i].setBorder(etchedBorder);

            if (gx == 4) {
                gx = 0;
                gy++;
            }
            c.gridx = gx;
            c.gridy = gy;
            c.gridwidth = 1;
            c.gridheight = 1;
            gx++;

            this.add(keyButtonStandard[i], c);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    // standard button action listener
        if (e.getSource() == keyButtonStandard[0]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) {
                } else {
                    String percent;
                    double result = Double.parseDouble(calculator.getNumber1()) / 100;
                    if (result % 1 == 0) {
                        percent = String.valueOf(Math.round(result));
                        dot = false;
                    }
                    else{
                        dot = true;
                        percent = String.valueOf(result);
                    }

                    this.setHistoryLabel(calculator.getNumber1() + "% =");
                    this.setNumLabel(percent);
                    calculator.setHistory(percent);
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[1]) {
            if (!operator) {
                this.setHistoryLabel(" ");
                calculator.setHistory("");
            }
            this.setNumLabel("0");
            dot = false;
        }
        else if (e.getSource() == keyButtonStandard[2]) {
            this.setHistoryLabel(" ");
            this.setNumLabel("0");
            calculator.setNumber1("0");
            calculator.setNumber2("0");
            calculator.setHistory("");
            operator = false;
            dot = false;
        }
        else if (e.getSource() == keyButtonStandard[3]) {
            if (calculator.getNumber1().charAt(calculator.getNumber1().length()-1)  == '.'){
                dot = false;
            }
            if (!operator) {
                if (calculator.getNumber1().length() == 1) {
                    calculator.setNumber1("0");
                    this.setNumLabel(calculator.getNumber1());
                } else {
                    calculator.setNumber1(calculator.getNumber1()
                            .substring(0, calculator.getNumber1()
                                    .length() - 1));
                    this.setNumLabel(calculator.getNumber1());
                }
            }
            else {
                if (calculator.getNumber2().length() == 1) {
                    calculator.setNumber2("0");
                    this.setNumLabel(calculator.getNumber2());
                } else {
                    calculator.setNumber2(calculator.getNumber2()
                            .substring(0, calculator.getNumber2()
                                    .length() - 1));
                    this.setNumLabel(calculator.getNumber2());
                }
            }

        }
        else if (e.getSource() == keyButtonStandard[4]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) {
                } else {
                    String result = String.valueOf(1 / Double.parseDouble(calculator.getNumber1()));
                    this.setHistoryLabel("1 ÷ " + calculator.getNumber1() + " =");
                    this.setNumLabel(result);
                    calculator.setHistory(result);
                }
                dot = true;
            }
        }
        else if (e.getSource() == keyButtonStandard[5]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) {
                } else {
                    String result;
                    if (Double.parseDouble(calculator.getNumber1()) % 1 == 0) {
                        result = String.valueOf(Math.round(
                                trigonometry.square2(Double.parseDouble(calculator.getNumber1()))));
                        dot = false;
                    }
                    else {
                        dot = true;
                        result = String.valueOf(trigonometry.square2(Double.parseDouble(calculator.getNumber1())));
                    }
                    this.setHistoryLabel("<html>" + calculator.getNumber1() + "<sup>2</sup></html>");
                    this.setNumLabel(result);
                    calculator.setHistory(result);
                }

            }
        }
        else if (e.getSource() == keyButtonStandard[6]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) {
                } else {
                    double resultNum = Math.pow(Double.parseDouble(calculator.getNumber1()), 1.0 / 2);
                    String result;
                    if (resultNum % 1 == 0) {
                        result = String.valueOf(Math.round(
                                Math.pow(Double.parseDouble(calculator.getNumber1()), 1.0 / 2)));
                        dot = false;
                    }
                    else {
                        dot = true;
                        result = String.valueOf(Math.pow(Double.parseDouble(calculator.getNumber1()), 1.0 / 2));
                    }
                    this.setHistoryLabel("√" + calculator.getNumber1() + " =");
                    this.setNumLabel(result);
                    calculator.setHistory(result);
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[7]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) { // division, method = 0
                } else {
                    this.setHistoryLabel(calculator.getNumber1() + "÷");
                    operator = true;
                    method = 0;
                    dot = false;
                    this.setNumLabel("0");
                    calculator.setHistory(calculator.getNumber1());
                }
            }
            else {
                keyButtonStandard[23].doClick(1);
                operator = false;
                keyButtonStandard[7].doClick(1);
            }
        }
        else if (e.getSource() == keyButtonStandard[8]) { // 7
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("7");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "7");
                }
            }
            else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("7");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "7");
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[9]) { // 8
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("8");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "8");
                }
            }
            else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("8");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "8");
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[10]) { // 9
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("9");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "9");
                }
            }
            else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("9");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "9");
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[11]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) { // multiplication, method = 1
                } else {
                    this.setHistoryLabel(calculator.getNumber1() + "x");
                    operator = true;
                    dot = false;
                    method = 1;
                    this.setNumLabel("0");
                    calculator.setHistory(calculator.getNumber1());
                }
            }
            else {
                keyButtonStandard[23].doClick(1);
                operator = false;
                keyButtonStandard[11].doClick(1);
            }
        }
        else if (e.getSource() == keyButtonStandard[12]) { // 4
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("4");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "4");
                }
            }
            else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("4");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "4");
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[13]) { // 5
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("5");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "5");
                }
            }
            else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("5");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "5");
                }
            }

        }
        else if (e.getSource() == keyButtonStandard[14]) { // 6
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("6");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "6");
                }
            }
            else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("6");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "6");
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[15]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) { // subtraction, method = 2
                } else {
                    this.setHistoryLabel(calculator.getNumber1() + "-");
                    operator = true;
                    dot = false;
                    method = 2;
                    this.setNumLabel("0");
                    calculator.setHistory(calculator.getNumber1());
                }
            }
            else {
                keyButtonStandard[23].doClick(1);
                operator = false;
                keyButtonStandard[15].doClick(1);
            }
        }
        else if (e.getSource() == keyButtonStandard[16]) { // 1
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("1");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "1");
                }
            } else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("1");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "1");
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[17]) { // 2
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("2");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "2");
                }
            } else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("2");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "2");
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[18]) { // 3
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("3");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "3");
                }
            } else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("3");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "3");
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[19]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) { // summation, method = 3
                } else {
                    this.setHistoryLabel(calculator.getNumber1() + "+");
                    operator = true;
                    dot = false;
                    method = 3;
                    this.setNumLabel("0");
                    calculator.setHistory(calculator.getNumber1());
                }
            } else {
                keyButtonStandard[23].doClick(1);
                operator = false;
                keyButtonStandard[19].doClick(1);
            }
        }
        else if (e.getSource() == keyButtonStandard[20]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) { // modulo, method = 4
                } else {
                    this.setHistoryLabel(calculator.getNumber1() + " mod");
                    operator = true;
                    dot = false;
                    method = 4;
                    this.setNumLabel("0");
                    calculator.setHistory(calculator.getNumber1());
                }
            } else {
                keyButtonStandard[23].doClick(1);
                operator = false;
                keyButtonStandard[20].doClick(1);
            }
        }
        else if (e.getSource() == keyButtonStandard[21]) { // 0
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("0");
                } else {
                    this.setNumLabel(calculator.getNumber1() + "0");
                }
            } else {
                if (calculator.getNumber2().equals("0")) {
                    this.setNumLabel("0");
                } else {
                    this.setNumLabel(calculator.getNumber2() + "0");
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[22]) {
            if (!operator) {
                if (!dot) {
                    this.setNumLabel(calculator.getNumber1() + ".");
                    dot = true;
                }
            } else {
                if (!dot) {
                    this.setNumLabel(calculator.getNumber2() + ".");
                    dot = true;
                }
            }
        }
        else if (e.getSource() == keyButtonStandard[23]) {
            if (calculator.getNumber2().equals("0") || calculator.getNumber2().equals("0.")){
            }
            else {
                operator = false;
                switch (method){
                    case 0 -> {
                        double resultNum = arithmetic.divide(Double.parseDouble(calculator.getNumber1()),
                                Double.parseDouble(calculator.getNumber2()));
                        String result;
                        // check number is an integer?
                        if (resultNum % 1 == 0){
                            result = String.valueOf(Math.round(resultNum));
                            dot = false;
                        }
                        else
                            result = String.valueOf(resultNum);

                        historyLabel.setText(calculator.getNumber1() + "÷" + calculator.getNumber2());
                        setNumLabel(result);
                        calculator.setHistory(result);
                        calculator.setNumber1(result);
                        calculator.setNumber2("0");
                    }
                    case 1 -> {
                        double resultNum = arithmetic.multiply(Double.parseDouble(calculator.getNumber1()),
                                Double.parseDouble(calculator.getNumber2()));
                        String result;
                        // check number is an integer?
                        if (resultNum % 1 == 0){
                            result = String.valueOf(Math.round(resultNum));
                            dot = false;
                        }
                        else
                            result = String.valueOf(resultNum);

                        historyLabel.setText(calculator.getNumber1() + "x" + calculator.getNumber2());
                        setNumLabel(result);
                        calculator.setHistory(result);
                        calculator.setNumber1(result);
                        calculator.setNumber2("0");
                    }
                    case 2 -> {
                        double resultNum = arithmetic.minus(Double.parseDouble(calculator.getNumber1()),
                                Double.parseDouble(calculator.getNumber2()));
                        String result;
                        // check number is an integer?
                        if (resultNum % 1 == 0){
                            result = String.valueOf(Math.round(resultNum));
                            dot = false;
                        }
                        else
                            result = String.valueOf(resultNum);

                        historyLabel.setText(calculator.getNumber1() + "-" + calculator.getNumber2());
                        setNumLabel(result);
                        calculator.setHistory(result);
                        calculator.setNumber1(result);
                        calculator.setNumber2("0");
                    }
                    case 3-> {
                        double resultNum = arithmetic.sum(Double.parseDouble(calculator.getNumber1()),
                                Double.parseDouble(calculator.getNumber2()));
                        String result;
                        // check number is an integer?
                        if (resultNum % 1 == 0){
                            result = String.valueOf(Math.round(resultNum));
                            dot = false;
                        }
                        else
                            result = String.valueOf(resultNum);

                        historyLabel.setText(calculator.getNumber1() + "+" + calculator.getNumber2());
                        setNumLabel(result);
                        calculator.setHistory(result);
                        calculator.setNumber1(result);
                        calculator.setNumber2("0");
                    }
                    case 4 -> {
                        double resultNum = arithmetic.modulo(Double.parseDouble(calculator.getNumber1()),
                                Double.parseDouble(calculator.getNumber2()));
                        String result;
                        // check number is an integer?
                        if (resultNum % 1 == 0){
                            result = String.valueOf(Math.round(resultNum));
                            dot = false;
                        }
                        else
                            result = String.valueOf(resultNum);

                        historyLabel.setText(calculator.getNumber1() + " mod " + calculator.getNumber2());
                        setNumLabel(result);
                        calculator.setHistory(result);
                        calculator.setNumber1(result);
                        calculator.setNumber2("0");
                    }
                }
            }
        }

        if (!this.isMaximumSizeSet()){
            if (displayLabel.getText().length() > 12)
                displayLabel.setFont(new Font(displayLabel.getFont().getFontName(), Font.BOLD, 30));
            else
                displayLabel.setFont(new Font(displayLabel.getFont().getFontName(), Font.BOLD, 55));
        }
    }

    private void setNumLabel(String num) {
        displayLabel.setText(num);
        if (!operator)
            calculator.setNumber1(num);
        else
            calculator.setNumber2(num);
    }

    private void setHistoryLabel(String his){
        historyLabel.setText(his);
    }
}
