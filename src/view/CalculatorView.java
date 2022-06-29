package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CalculatorView extends JPanel {

    private JButton navigationButton;
    private JComboBox categoriesComboBox;
    private JButton historyButton;
    private JLabel historyLabel;
    private JLabel numberLabel;

    public CalculatorView() {

        this.setSize(545, 300);
        //this.setPreferredSize(new Dimension(562, 326));
        this.setLocation(0,0);
        this.setBorder(new LineBorder(Color.BLUE, 1));
        this.setBackground(new Color(234, 234, 234));
        this.setLayout(null);

        // navigation Button
        navigationButton = new JButton();
        navigationButton.setSize(40, 40);
//        navigationButton.setPreferredSize(new Dimension(40, 40));
        navigationButton.setLocation(25, 28);
        navigationButton.setIcon(new ImageIcon("src/image/icon-calculator/navigation.png"));
        navigationButton.setBackground(null);

        // categories combo box
        String[] categories ={"Standard","Scientific","Programmer"};
        categoriesComboBox = new JComboBox<>(categories);
        categoriesComboBox.setBounds(73, 28, 274, 40);
//        categoriesComboBox.setPreferredSize(new Dimension(274, 44));
        categoriesComboBox.setFont(new Font("Itim", Font.PLAIN, 40));

        // history button
        historyButton = new JButton();
        historyButton.setSize(30, 30);
//        historyButton.setPreferredSize(new Dimension(30, 30));
        historyButton.setLocation(497, 37);
        historyButton.setIcon(new ImageIcon("src/image/icon-calculator/history.png"));
        historyButton.setBackground(null);

        // history label
        historyLabel = new JLabel("0", SwingConstants.RIGHT);
        historyLabel.setSize(520, 58);
//        historyLabel.setPreferredSize(new Dimension(550, 58));
        historyLabel.setFont(new Font("Inter", Font.BOLD, 48));
        historyLabel.setLocation(4, 125);
        historyLabel.setForeground(new Color(105, 103, 103));

        // numberLabel
        numberLabel = new JLabel("0", SwingConstants.RIGHT);
        numberLabel.setSize(540, 155);
//        numberLabel.setPreferredSize(new Dimension(550, 155));
        numberLabel.setFont(new Font("Inter", Font.BOLD, 128));
        numberLabel.setLocation(4, 170);

        //add component to panel
        this.add(navigationButton);
        this.add(categoriesComboBox);
        this.add(historyButton);
        this.add(historyLabel);
        this.add(numberLabel);
    }
}
