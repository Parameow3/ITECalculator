package view;

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

    private Border etchedBorder;

    private Calculator calculator;

    private int gx = 0,gy = 1;


    public StandardView() {

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
        c.gridwidth = 4;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(displayLabel, c);
        createKey();
    }

    private void createKey() { // src/image/icon-standard/Plus.png    || i == 15 || i == 19
        String[] buttonIconStandard = {"%", "CE", "C", "src/image/icon-standard/delete.png", "1/x",
                "<html>X<sup>2</sup></html>", "√x",
                "src/image/divide2.gif", "7", "8", "9", "src/image/multiply2.gif", "4", "5", "6",
                "src/image/subtraction.gif", "1", "2", "3", "src/image/addition.gif", "mod", "0", "." ,
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
    }

    private void setNumLabel(String num) {

        calculator.setNumber(num);
        displayLabel.setText(num);
    }
}
