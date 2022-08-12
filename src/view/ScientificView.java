package view;

import model.Calculator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificView extends JPanel implements ActionListener {

    private GridBagConstraints c;
    private JButton[] keyButtonScientific = new JButton[30];
    private JLabel displayLabel;

    private Border etchedBorder;

    private Calculator calculator;

    private int gx = 0,gy = 1;

    public ScientificView(){
        this.setLayout(new GridBagLayout());

        // initiate object
        calculator = new Calculator();
        displayLabel = new JLabel(calculator.getNumber());
        c = new GridBagConstraints();
        etchedBorder = new EtchedBorder();

        displayLabel.setFont(new Font("Itim", Font.PLAIN, 55));
        displayLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 5, Color.LIGHT_GRAY));
        displayLabel.setPreferredSize(new Dimension(displayLabel.getWidth(), 65));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        // customize constraint for label
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(displayLabel, c);
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

        calculator.setNumber(num);
        displayLabel.setText(num);
    }
}
