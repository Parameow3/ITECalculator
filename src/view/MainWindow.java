package view;

import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import model.Calculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainWindow implements ActionListener {

    private final JFrame mainFrame;
    private final String[] calculatorCal = {"Standard", "Scientific", "Programmer"};
    private final String[] converterCal = {"Currency", "Data", " Number"};

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JToolBar myToolbar;
    private JButton navigateBTN;
    private combo_suggestion.ComboBoxSuggestion calculatorCB;
    private JButton historyBTN;

    private DrawerController drawer;



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


        calculatorCB = new combo_suggestion.ComboBoxSuggestion();
        calculatorCB.setEditable(false);
        calculatorCB.setModel(new javax.swing.DefaultComboBoxModel(calculatorCal));

        historyBTN = new JButton();
        // ------------------------

        customizeUI();
    }



    private void customizeUI() {

        // use drawer for draw navigation slide menu in this calculator

        drawer = Drawer.newDrawer(mainFrame)
                .background(new Color(90, 90, 90))
                .closeOnPress(true)
                .backgroundTransparent(0.3f)
                .drawerBackground(new Color(199, 199, 199))
                .leftDrawer(true)
                .enableScroll(true)
                .enableScrollUI(false)
                .headerHeight(150)
                .header(new DrawerItem("EveryDay Calculator ").font(new Font("Itim", Font.BOLD, 18))
                        .icon(new ImageIcon(Objects.requireNonNull(getClass()
                                .getResource("/image/icon-calculator/navigation.png")))).build())
                .space(10)
                .addChild(new DrawerItem("Calculator ")
                        .icon(new ImageIcon(Objects.requireNonNull(getClass()
                                .getResource("/image/icon-calculator/navigation.png")))).build())
                .addChild(new DrawerItem("Converter ")
                        .icon(new ImageIcon(Objects.requireNonNull(getClass()
                                .getResource("/image/icon-calculator/navigation.png")))).build())
                .addFooter(new DrawerItem("Setting ")
                        .icon(new ImageIcon(Objects.requireNonNull(getClass()
                                .getResource("/image/icon-calculator/navigation.png")))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int index, DrawerItem item) {
                        if(drawer.isShow()){
                            drawer.hide();
                        }

                        if (index == 0) { // child no.1
                            calculatorCB.setModel(new javax.swing.DefaultComboBoxModel(calculatorCal));
                            cardLayout.show(mainPanel, "0");
                        }
                        else if (index == 1) { // child no.2
                            calculatorCB.setModel(new javax.swing.DefaultComboBoxModel(converterCal));
                            cardLayout.show(mainPanel, "3");
                        }

                    }
                })
                .build();

        // customize component for toolbar
        navigateBTN.setIcon(new ImageIcon("src/image/icon-calculator/navigation.png"));
        navigateBTN.setFocusable(false);
        navigateBTN.addActionListener(this);

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
        mainPanel.add(new CurrencyView(), "3");
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
            if (calculatorCB.getSelectedItem().toString().equals("Standard")) {
                cardLayout.show(mainPanel, "0");
            } else if (calculatorCB.getSelectedItem().toString().equals("Scientific")) {
                cardLayout.show(mainPanel, "1");
            } else if (calculatorCB.getSelectedItem().toString().equals("Programmer")) {
                cardLayout.show(mainPanel, "2");
            } else if (calculatorCB.getSelectedItem().toString().equals("Currency")) {
                cardLayout.show(mainPanel, "3");
            }
        }

        if (e.getSource()==navigateBTN) {
            if (drawer.isShow()) {
                drawer.hide();
            } else {
                drawer.show();
            }
        }
    }
}