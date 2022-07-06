package view;

import javax.swing.*;
import java.awt.*;

public class MainWindowView extends JFrame {

    private JToolBar toolBar;
    private JButton navigationButton;
    private JComboBox categoriesComboBox;
    private JButton historyButton;
    public MainWindowView() {

        this.setSize(562, 768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        this.add(new CalculatorView(), BorderLayout.CENTER);


        this.add(new StandardView(), BorderLayout.SOUTH);
//        this.add(new ScientificView(), BorderLayout.SOUTH);


        // navigation Button
        navigationButton = new JButton();
        //navigationButton.setSize(40, 40);
        navigationButton.setPreferredSize(new Dimension(40, 40));
        //navigationButton.setLocation(25, 28);
        navigationButton.setIcon(new ImageIcon("src/image/icon-calculator/navigation.png"));
        navigationButton.setBackground(this.getBackground());

        // categories combo box
        String[] categories ={"Standard","Scientific","Programmer"};
        categoriesComboBox = new JComboBox<>(categories);
        //categoriesComboBox.setBounds(73, 28, 274, 40);
        categoriesComboBox.setPreferredSize(new Dimension(274, 40));
        categoriesComboBox.setFont(new Font("Itim", Font.PLAIN, 40));
        categoriesComboBox.setFocusable(false);
        categoriesComboBox.setOpaque(true);

        // history button
        historyButton = new JButton();
        //historyButton.setSize(30, 30);
        historyButton.setPreferredSize(new Dimension(30, 30));
        //historyButton.setLocation(497, 37);
        historyButton.setIcon(new ImageIcon("src/image/icon-calculator/history.png"));
        historyButton.setBackground(this.getBackground());

        toolBar = new JToolBar();

        toolBar.add(navigationButton);
        toolBar.add(categoriesComboBox);
        toolBar.add(historyButton);

        this.getContentPane().add(toolBar, BorderLayout.PAGE_START);

        this.setBackground(new Color(234, 234, 234));
        this.setVisible(true);
    }
}
