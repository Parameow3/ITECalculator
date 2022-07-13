package view;

import model.Calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JPanel {

    private JButton navigationButton;
    private JComboBox categoriesComboBox;
    private JButton historyButton;
    private JLabel numLabel;
    private Calculator calculator;

    public CalculatorView(Calculator calculator) {
        this.calculator = calculator;

        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        numLabel = new JLabel(calculator.getNumber());


        // navigation Button
        navigationButton = new JButton();
        //navigationButton.setSize(40, 40);
        //navigationButton.setPreferredSize(new Dimension(40, 40));
        //navigationButton.setLocation(25, 28);
        navigationButton.setIcon(new ImageIcon("src/image/icon-calculator/navigation.png"));
        navigationButton.setBackground(this.getBackground());

        // categories combo box
        String[] categories ={"Standard","Scientific","Programmer"};
        categoriesComboBox = new JComboBox<>(categories);
        //categoriesComboBox.setBounds(73, 28, 274, 40);
        //categoriesComboBox.setPreferredSize(new Dimension(274, 40));
        categoriesComboBox.setFont(new Font("Itim", Font.PLAIN, 40));
        categoriesComboBox.setFocusable(false);
        categoriesComboBox.setOpaque(true);

        // history button
        historyButton = new JButton();
        //historyButton.setSize(30, 30);
        //historyButton.setPreferredSize(new Dimension(30, 30));
        //historyButton.setLocation(497, 37);
        historyButton.setIcon(new ImageIcon("src/image/icon-calculator/history.png"));
        historyButton.setBackground(this.getBackground());

        g.gridx = 0;
        g.gridy = 1;
        g.weightx = 0.1;
        this.add(navigationButton, g);

        g.gridx = 1;
        g.gridy = 1;
        this.add(categoriesComboBox, g);

        g.gridx = 2;
        g.gridy = 1;
        g.weightx = 1;
        this.add(historyButton, g);

        g.gridx = 2;
        g.gridy = 2;
        this.add(numLabel, g);
        numLabel.setFont(new Font("Itim", Font.BOLD, 120));

    }

    public JLabel setNumLabel(){
        return this.numLabel;
    }
}
