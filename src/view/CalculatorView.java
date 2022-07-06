package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CalculatorView extends JPanel {

    private JLabel historyLabel;
    private JLabel numberLabel;


    public CalculatorView() {

        //this.setSize(545, 300);
        this.setPreferredSize(new Dimension(545, 260));
        //this.setLocation(0,0);
        this.setBorder(new LineBorder(Color.BLUE, 1));
        this.setBackground(new Color(234, 234, 234));


        // history label
        historyLabel = new JLabel("0", SwingConstants.RIGHT);
//        historyLabel.setSize(520, 58);
        historyLabel.setPreferredSize(new Dimension(550, 58));
        historyLabel.setFont(new Font("Inter", Font.BOLD, 48));
//        historyLabel.setLocation(4, 125);
        historyLabel.setForeground(new Color(105, 103, 103));

        // numberLabel
        numberLabel = new JLabel("0", SwingConstants.RIGHT);
//        numberLabel.setSize(540, 155);
        numberLabel.setPreferredSize(new Dimension(550, 155));
        numberLabel.setFont(new Font("Inter", Font.BOLD, 128));
//        numberLabel.setLocation(4, 170);



        //add component to panel
//        this.add(navigationButton, BorderLayout.NORTH);
//        this.add(categoriesComboBox, BorderLayout.NORTH);
//        this.add(historyButton, BorderLayout.NORTH);

        this.add(historyLabel, BorderLayout.CENTER);
        this.add(numberLabel, BorderLayout.SOUTH);
    }
}
