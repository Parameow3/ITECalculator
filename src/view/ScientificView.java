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

public class ScientificView extends JPanel implements ActionListener {

    private GridBagConstraints c;
    private JButton[] keyButtonScientific = new JButton[30];
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

    public ScientificView(){
        this.setLayout(new GridBagLayout());

        // initiate object
        calculator = new Calculator();
        trigonometry = new Trigonometry();
        arithmetic = new Arithmetic();
        displayLabel = new JLabel(calculator.getNumber1());
        historyLabel = new JLabel(" ");
        c = new GridBagConstraints();
        etchedBorder = new EtchedBorder();

        displayLabel.setFont(new Font("Itim", Font.PLAIN, 55));
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
        c.gridwidth = 5;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(displayPanel, c);
        createKey();
    }

    private void createKey() { // src/image/icon-standard/Plus.png    || i == 15 || i == 19
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
                keyButtonScientific[i].setFont(new Font("Itim", Font.BOLD, 24));
            }

            if (i == 25)
                keyButtonScientific[i].setFont(new Font("Itim", Font.BOLD, 15));
            keyButtonScientific[i].setFocusable(false);
            keyButtonScientific[i].setBackground(new Color(199, 199, 199));
            keyButtonScientific[i].addActionListener(this);

            keyButtonScientific[i].setBorder(etchedBorder);

            if (gx == 5) {
                gx = 0;
                gy++;
            }
            c.gridx = gx;
            c.gridy = gy;
            c.gridwidth = 1;
            c.gridheight = 1;
            gx++;

            this.add(keyButtonScientific[i], c);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
// scientific button action listener
        if (e.getSource() == keyButtonScientific[0]){
//            if (calculator.getNumber1().equals("0")) {
//                this.setNumLabel("(");
//            } else {
//                this.setNumLabel(calculator.getNumber1() + "(");
//            }
        }
        else if (e.getSource() == keyButtonScientific[1]) {
//            if (calculator.getNumber1().equals("0")) {
//                this.setNumLabel(")");
//            } else {
//                this.setNumLabel(calculator.getNumber1() + ")");
//            }
        }
        else if (e.getSource() == keyButtonScientific[2]) {
            if (!operator) {
                this.setHistoryLabel(" ");
                calculator.setHistory("");
            }
            this.setNumLabel("0");
            dot = false;
        }
        else if (e.getSource() == keyButtonScientific[3]) {
            this.setHistoryLabel(" ");
            this.setNumLabel("0");
            calculator.setNumber1("0");
            calculator.setNumber2("0");
            calculator.setHistory("");
            operator = false;
            dot = false;
        }
        else if (e.getSource() == keyButtonScientific[4]) {
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
            } else {
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
        else if (e.getSource() == keyButtonScientific[5]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) {
                } else {
                    String result;
                    if (Double.parseDouble(calculator.getNumber1()) % 1 == 0) {
                        result = String.valueOf(Math.round(
                                trigonometry.factorial(Double.parseDouble(calculator.getNumber1()))));
                        dot = false;
                    }
                    else {
                        dot = true;
                        result = String.valueOf(trigonometry.factorial(Double.parseDouble(calculator.getNumber1())));
                    }
                    this.setHistoryLabel(calculator.getNumber1() + "! =");
                    this.setNumLabel(result);
                    calculator.setHistory(result);
                }
            }
        }
        else if (e.getSource() == keyButtonScientific[6]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0.")) {
                } else {
                    String result;
                    double resultNum = trigonometry.sind(Double.parseDouble(calculator.getNumber1()));
                    if (resultNum % 1 == 0 || String.valueOf(resultNum).length() > 21) {
                        result = String.valueOf(Math.round(resultNum));
                        dot = false;
                    }
                    else {
                        dot = true;
                        result = String.valueOf(resultNum);
                    }
                    this.setHistoryLabel("sin(" + calculator.getNumber1() + "˚) =");
                    this.setNumLabel(result);
                    calculator.setHistory(result);
                }
            }
        }
        else if (e.getSource() == keyButtonScientific[7]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0.")) {
                } else {
                    String result;
                    double resultNum = trigonometry.cosd(Double.parseDouble(calculator.getNumber1()));
                    if (resultNum % 1 == 0 || String.valueOf(resultNum).length() > 21) {
                        result = String.valueOf(Math.round(resultNum));
                        dot = false;
                    }
                    else {
                        dot = true;
                        result = String.valueOf(resultNum);
                    }
                    this.setHistoryLabel("cos(" + calculator.getNumber1() + "˚) =");
                    this.setNumLabel(result);
                    calculator.setHistory(result);
                }
            }
        }
        else if (e.getSource() == keyButtonScientific[8]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0.")) {
                } else {
                    String result;
                    double resultNum = trigonometry.tand(Double.parseDouble(calculator.getNumber1()));
                    if (resultNum % 1 == 0 || String.valueOf(resultNum).length() > 21) {
                        result = String.valueOf(Math.round(resultNum));
                        dot = false;
                    }
                    else {
                        dot = true;
                        result = String.valueOf(resultNum);
                    }
                    this.setHistoryLabel("tan(" + calculator.getNumber1() + "˚) =");
                    this.setNumLabel(result);
                    calculator.setHistory(result);
                }
            }
        }
        else if (e.getSource() == keyButtonScientific[9]) {
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
                keyButtonScientific[29].doClick(1);
                operator = false;
                keyButtonScientific[9].doClick(1);
            }
        }
        else if (e.getSource() == keyButtonScientific[10]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0")) {
                    this.setNumLabel("3.14");
                    historyLabel.setText("π = 180˚");
                } else {
                    double resultNum = Double.parseDouble(calculator.getNumber1()) * 3.14;
                    String result;
                    // check number is an integer?
                    if (resultNum % 1 == 0){
                        result = String.valueOf(Math.round(resultNum));
                        dot = false;
                    }
                    else
                        result = String.valueOf(resultNum);

                    historyLabel.setText(calculator.getNumber1() + "x 3.14");
                    setNumLabel(result);
                    calculator.setHistory(result);
                    calculator.setNumber1(result);
                    calculator.setNumber2("0");
                }
            }
        }
        else if (e.getSource() == keyButtonScientific[11]) { // 7
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
        else if (e.getSource() == keyButtonScientific[12]) { // 8
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
        else if (e.getSource() == keyButtonScientific[13]) { // 9
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
        else if (e.getSource() == keyButtonScientific[14]) {
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
                keyButtonScientific[29].doClick(1);
                operator = false;
                keyButtonScientific[14].doClick(1);
            }
        }
        else if (e.getSource() == keyButtonScientific[15]) {
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
        else if (e.getSource() == keyButtonScientific[16]) { // 4
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
        else if (e.getSource() == keyButtonScientific[17]) { // 5
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
        else if (e.getSource() == keyButtonScientific[18]) { // 6
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
        else if (e.getSource() == keyButtonScientific[19]) {
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
                keyButtonScientific[29].doClick(1);
                operator = false;
                keyButtonScientific[19].doClick(1);
            }
        }
        else if (e.getSource() == keyButtonScientific[20]) {
            if (!operator) {
                if (calculator.getNumber1().equals("0") || calculator.getNumber1().equals("0.")) {
                } else {
                    String result;
                    if (Double.parseDouble(calculator.getNumber1()) % 1 == 0) {
                        result = String.valueOf(Math.round(
                                trigonometry.square2(Double.parseDouble(calculator.getNumber1()))));
                        dot = false;
                    } else {
                        dot = true;
                        result = String.valueOf(trigonometry.square2(Double.parseDouble(calculator.getNumber1())));
                    }
                    this.setHistoryLabel("<html>" + calculator.getNumber1() + "<sup>2</sup></html>");
                    this.setNumLabel(result);
                    calculator.setHistory(result);
                }
            }
        }
        else if (e.getSource() == keyButtonScientific[21]) { // 1
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
        else if (e.getSource() == keyButtonScientific[22]) { // 2
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
        else if (e.getSource() == keyButtonScientific[23]) { // 3
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
        else if (e.getSource() == keyButtonScientific[24]) {
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
                keyButtonScientific[29].doClick(1);
                operator = false;
                keyButtonScientific[24].doClick(1);
            }
        }
        else if (e.getSource() == keyButtonScientific[25]) {

        }
        else if (e.getSource() == keyButtonScientific[26]) {
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
        else if (e.getSource() == keyButtonScientific[27]) { // 0
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
        else if (e.getSource() == keyButtonScientific[28]) {
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
        else if (e.getSource() == keyButtonScientific[29]) {
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
