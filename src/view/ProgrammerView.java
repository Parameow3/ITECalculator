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
    private JLabel hexLabel;
    private JLabel decLabel;
    private JLabel octLabel;
    private JLabel binLabel;
    private Border etchedBorder;

    private Calculator calculator;
    private NumberSystemConversion conversion;

    private int gx = 0,gy = 5;

    public ProgrammerView(){
        this.setLayout(new GridBagLayout());

        // initiate object
        calculator = new Calculator();
        conversion = new NumberSystemConversion();
        displayLabel = new JLabel(calculator.getNumber());
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
        displayLabel.setFont(new Font("Inter", Font.PLAIN, 55));
        displayLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 5, Color.LIGHT_GRAY));
        displayLabel.setPreferredSize(new Dimension(displayLabel.getWidth(), 65));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);

        hexLabel.setFont(new Font("Inter", Font.PLAIN, 15));
        hexLabel.setBorder(new EmptyBorder(0,10,0,0));
        hexLabel.setHorizontalAlignment(JLabel.LEFT);

        decLabel.setFont(new Font("Inter", Font.PLAIN, 15));
        decLabel.setBorder(new EmptyBorder(0,10,0,0));
        decLabel.setHorizontalAlignment(JLabel.LEFT);

        octLabel.setFont(new Font("Inter", Font.PLAIN, 15));
        octLabel.setBorder(new EmptyBorder(0,10,0,0));
        octLabel.setHorizontalAlignment(JLabel.LEFT);

        binLabel.setFont(new Font("Inter", Font.PLAIN, 15));
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
        this.add(displayLabel, c);

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
                keyButtonProgrammer[i].setFont(new Font("Inter", Font.BOLD, 24));
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
