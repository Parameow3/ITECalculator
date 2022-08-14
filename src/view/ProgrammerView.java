package view;

import Algorithm.NumberSystemConversion;
import model.Calculator;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgrammerView extends JPanel implements ActionListener {

    private GridBagConstraints c;
    private JButton[] keyButtonProgrammer= new JButton[30];
    private JLabel displayLabel;
    private JPanel displayPanel;
    private combo_suggestion.ComboBoxSuggestion numComboBox;
    private JLabel hexLabel;
    private JLabel decLabel;
    private JLabel octLabel;
    private JLabel binLabel;
    private Border etchedBorder;

    private Calculator calculator;
    private NumberSystemConversion conversion;

    private int gx = 0,gy = 5;
    private final String[] numList = {"Decimal", "Binary", "Hexadecimal", "Octal"};

    public ProgrammerView(){
        this.setLayout(new GridBagLayout());

        // initiate object
        calculator = new Calculator();
        conversion = new NumberSystemConversion();
        displayLabel = new JLabel(calculator.getNumber1());
        numComboBox = new combo_suggestion.ComboBoxSuggestion();
        numComboBox.setEditable(false);
        numComboBox.setModel(new javax.swing.DefaultComboBoxModel(numList));
        numComboBox.setFocusable(false);
        numComboBox.addActionListener(this);

        hexLabel = new JLabel("HEX:");
        decLabel = new JLabel("DEC:");
        octLabel = new JLabel("OCT:");
        binLabel = new JLabel("BIN  :");
        c = new GridBagConstraints();
        etchedBorder = new EtchedBorder();

        customLabel();
        createKey();
    }

    private void customLabel() {
        displayLabel.setFont(new Font("Itim", Font.PLAIN, 55));
        displayLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 5, Color.LIGHT_GRAY));
        displayLabel.setPreferredSize(new Dimension(displayLabel.getWidth(), 65));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);

        displayPanel = new JPanel(new BorderLayout());
        displayPanel.add(numComboBox, BorderLayout.PAGE_START);
        displayPanel.add(displayLabel, BorderLayout.CENTER);

        hexLabel.setFont(new Font("Itim", Font.PLAIN, 15));
        hexLabel.setBorder(new EmptyBorder(0,10,0,0));
        hexLabel.setHorizontalAlignment(JLabel.LEFT);

        decLabel.setFont(new Font("Itim", Font.PLAIN, 15));
        decLabel.setBorder(new EmptyBorder(0,10,0,0));
        decLabel.setHorizontalAlignment(JLabel.LEFT);

        octLabel.setFont(new Font("Itim", Font.PLAIN, 15));
        octLabel.setBorder(new EmptyBorder(0,10,0,0));
        octLabel.setHorizontalAlignment(JLabel.LEFT);

        binLabel.setFont(new Font("Itim", Font.PLAIN, 15));
        binLabel.setBorder(new EmptyBorder(0,10,0,0));
        binLabel.setHorizontalAlignment(JLabel.LEFT);

        // customize constraint for display label
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(displayPanel, c);

        c.gridy = 1;
        c.gridwidth = 5;
        c.gridheight = 1;
        this.add(hexLabel, c);

        c.gridy = 2;
        c.gridwidth = 5;
        c.gridheight = 1;
        this.add(decLabel, c);

        c.gridy = 3;
        c.gridwidth = 5;
        c.gridheight = 1;
        this.add(octLabel, c);

        c.gridy = 4;
        c.gridwidth = 5;
        c.gridheight = 1;
        this.add(binLabel, c);
    }

    private void createKey() { // src/image/icon-standard/Plus.png    || i == 15 || i == 19
        String[] buttonIcon = {"A", "AND", "OR", "NOT", "src/image/icon-scientific/delete-small.png",
                "B", "(", ")", "%", "CE", "C", "7", "8", "9", "<<", "D", "4", "5", "6",
                ">>", "E", "1", "2", "3", "~", "F", "XOR", "0", ".",
                "src/image/icon-scientific/Equal-small.png"};
        for (int i = 0; i < 30; i++) {


            if ( i == 4 || i == 29) {

                keyButtonProgrammer[i] = new JButton(new ImageIcon(buttonIcon[i]));
            } else {
                keyButtonProgrammer[i] = new JButton(buttonIcon[i]);
                keyButtonProgrammer[i].setFont(new Font("Itim", Font.BOLD, 24));
            }

            keyButtonProgrammer[i].setFocusable(false);
            keyButtonProgrammer[i].setBackground(new Color(199, 199, 199));
            keyButtonProgrammer[i].addActionListener(this);

            keyButtonProgrammer[i].setBorder(etchedBorder);

            if (gx == 5) {
                gx = 0;
                gy++;
            }
            c.gridx = gx;
            c.gridy = gy;
            c.gridwidth = 1;
            c.gridheight = 1;
            gx++;

            this.add(keyButtonProgrammer[i], c);
        }
        keyButtonProgrammer[0].setEnabled(false);
        keyButtonProgrammer[5].setEnabled(false);
        keyButtonProgrammer[10].setEnabled(false);
        keyButtonProgrammer[15].setEnabled(false);
        keyButtonProgrammer[20].setEnabled(false);
        keyButtonProgrammer[25].setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == numComboBox) {
            for (int i = 0; i < 30; i++) {
                keyButtonProgrammer[i].setEnabled(true);
            }
            if (numComboBox.getSelectedItem().equals("Decimal")){
                keyButtonProgrammer[0].setEnabled(false);
                keyButtonProgrammer[5].setEnabled(false);
                keyButtonProgrammer[10].setEnabled(false);
                keyButtonProgrammer[15].setEnabled(false);
                keyButtonProgrammer[20].setEnabled(false);
                keyButtonProgrammer[25].setEnabled(false);
            } else if (numComboBox.getSelectedItem().equals("Binary")){
                keyButtonProgrammer[0].setEnabled(false);
                keyButtonProgrammer[5].setEnabled(false);
                keyButtonProgrammer[10].setEnabled(false);
                keyButtonProgrammer[15].setEnabled(false);
                keyButtonProgrammer[20].setEnabled(false);
                keyButtonProgrammer[25].setEnabled(false);
                keyButtonProgrammer[11].setEnabled(false);
                keyButtonProgrammer[12].setEnabled(false);
                keyButtonProgrammer[13].setEnabled(false);
                keyButtonProgrammer[16].setEnabled(false);
                keyButtonProgrammer[17].setEnabled(false);
                keyButtonProgrammer[18].setEnabled(false);
                keyButtonProgrammer[6].setEnabled(false);
                keyButtonProgrammer[7].setEnabled(false);
                keyButtonProgrammer[23].setEnabled(false);
                keyButtonProgrammer[22].setEnabled(false);
                keyButtonProgrammer[28].setEnabled(false);
                keyButtonProgrammer[8].setEnabled(false);
            } else if (numComboBox.getSelectedItem().equals("Hexadecimal")){
                keyButtonProgrammer[11].setEnabled(false);
                keyButtonProgrammer[12].setEnabled(false);
                keyButtonProgrammer[13].setEnabled(false);
                keyButtonProgrammer[16].setEnabled(false);
                keyButtonProgrammer[17].setEnabled(false);
                keyButtonProgrammer[18].setEnabled(false);
                keyButtonProgrammer[6].setEnabled(false);
                keyButtonProgrammer[7].setEnabled(false);
                keyButtonProgrammer[23].setEnabled(false);
                keyButtonProgrammer[27].setEnabled(false);
                keyButtonProgrammer[28].setEnabled(false);
                keyButtonProgrammer[8].setEnabled(false);
                keyButtonProgrammer[21].setEnabled(false);
                keyButtonProgrammer[22].setEnabled(false);
            } else if (numComboBox.getSelectedItem().equals("Octal")){
                keyButtonProgrammer[0].setEnabled(false);
                keyButtonProgrammer[5].setEnabled(false);
                keyButtonProgrammer[10].setEnabled(false);
                keyButtonProgrammer[15].setEnabled(false);
                keyButtonProgrammer[20].setEnabled(false);
                keyButtonProgrammer[25].setEnabled(false);
                keyButtonProgrammer[12].setEnabled(false);
                keyButtonProgrammer[13].setEnabled(false);
                keyButtonProgrammer[6].setEnabled(false);
                keyButtonProgrammer[7].setEnabled(false);
                keyButtonProgrammer[28].setEnabled(false);
                keyButtonProgrammer[8].setEnabled(false);
            }
        }

        if (e.getSource() == keyButtonProgrammer[0]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("A");
            } else {
                this.setNumLabel(calculator.getNumber1() + "A");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[4]) {
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
        else if (e.getSource() == keyButtonProgrammer[5]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("B");
            } else {
                this.setNumLabel(calculator.getNumber1() + "B");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[9]) {
            this.setNumLabel("0");
        }
        else if (e.getSource() == keyButtonProgrammer[10]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("C");
            } else {
                this.setNumLabel(calculator.getNumber1() + "C");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[11]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("7");
            } else {
                this.setNumLabel(calculator.getNumber1() + "7");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[12]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("8");
            } else {
                this.setNumLabel(calculator.getNumber1() + "8");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[13]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("9");
            } else {
                this.setNumLabel(calculator.getNumber1() + "9");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[15]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("D");
            } else {
                this.setNumLabel(calculator.getNumber1() + "D");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[16]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("4");
            } else {
                this.setNumLabel(calculator.getNumber1() + "4");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[17]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("5");
            } else {
                this.setNumLabel(calculator.getNumber1() + "5");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[18]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("6");
            } else {
                this.setNumLabel(calculator.getNumber1() + "6");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[20]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("E");
            } else {
                this.setNumLabel(calculator.getNumber1() + "E");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[21]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("1");
            } else {
                this.setNumLabel(calculator.getNumber1() + "1");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[22]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("2");
            } else {
                this.setNumLabel(calculator.getNumber1() + "2");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[23]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("3");
            } else {
                this.setNumLabel(calculator.getNumber1() + "3");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[25]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("F");
            } else {
                this.setNumLabel(calculator.getNumber1() + "F");
            }
        }
        else if (e.getSource() == keyButtonProgrammer[27]) {
            if (calculator.getNumber1().equals("0")) {
                this.setNumLabel("0");
            } else {
                this.setNumLabel(calculator.getNumber1() + "0");
            }
        }
    }

    private void setNumLabel(String num) {
        displayLabel.setText(num);
        calculator.setNumber1(num);
    }
}
