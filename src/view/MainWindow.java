package view;

import model.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements ActionListener {

    private final JFrame mainFrame;
    private final String[] calculatorCal = {"Standard", "Scientific", "Programmer"};

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JToolBar myToolbar;
    private JButton navigateBTN;
    private JComboBox calculatorCB;
    private JButton historyBTN;



    public MainWindow() {

        // Frame for calculator
        mainFrame = new JFrame();

        // Panel for main window
        mainPanel = new JPanel();

        // Card Layout for Main Panel
        cardLayout = new CardLayout();

        // toolbar for calculator
        myToolbar = new JToolBar();
        // ------------------------

        // component for toolbar
        navigateBTN = new JButton();

        calculatorCB = new JComboBox<>(calculatorCal);

        historyBTN = new JButton();
        // ------------------------

        customizeUI();
    }



    private void customizeUI() {

        // customize component for toolbar
        navigateBTN.setIcon(new ImageIcon("src/image/icon-calculator/navigation.png"));
        navigateBTN.setFocusable(false);

        calculatorCB.setFont(new Font("Itim", Font.PLAIN, 30));
        calculatorCB.setFocusable(false);
        calculatorCB.addActionListener(this);

        historyBTN.setIcon(new ImageIcon("src/image/icon-calculator/history.png"));
        historyBTN.setFocusable(false);

        myToolbar.add(navigateBTN);
        myToolbar.add(calculatorCB);
        myToolbar.add(historyBTN);
        // ----------------------------------

        // customize Main panel
        mainPanel.setLayout(cardLayout);
        mainPanel.add(new StandardView(), "0");
        mainPanel.add(new ScientificView(), "1");
        mainPanel.add(new ProgrammerView(), "2");
        cardLayout.show(mainPanel, "0");
        //----------------------------------

        // customize frame
        mainFrame.setMinimumSize(new Dimension(420, 600));
        mainFrame.setTitle("Everyday Calculator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        // add component to frame
        mainFrame.getContentPane().add(myToolbar, BorderLayout.PAGE_START);
        mainFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==calculatorCB) {
            switch (calculatorCB.getSelectedIndex()) {
                case 0 -> cardLayout.show(mainPanel, "0");
                case 1 -> cardLayout.show(mainPanel, "1");
                case 2 -> cardLayout.show(mainPanel, "2");
            }
        }
    }
}