package view;

import model.Calculator;

import javax.swing.*;
import java.awt.*;

public class MainWindow{

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

        calculatorCB.setFont(new Font("Itim", Font.PLAIN, 40));
        calculatorCB.setFocusable(false);

        historyBTN.setIcon(new ImageIcon("src/image/icon-calculator/history.png"));
        historyBTN.setFocusable(false);

        myToolbar.add(navigateBTN);
        myToolbar.add(calculatorCB);
        myToolbar.add(historyBTN);
        // ----------------------------------

        // customize Main panel
        mainPanel.setLayout(cardLayout);
        mainPanel.add(new CalculatorView());

        //----------------------------------

        // customize frame
        mainFrame.setMinimumSize(new Dimension(400, 600));
        mainFrame.setTitle("Everyday Calculator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        // add component to frame
        mainFrame.getContentPane().add(myToolbar, BorderLayout.PAGE_START);
        mainFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        new MainWindow();
    }
}