package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DataView extends JPanel implements ActionListener {
    private GridBagConstraints c;
    private combo_suggestion.ComboBoxSuggestion firstComboBox;
    private combo_suggestion.ComboBoxSuggestion secondComboBox;
    private JPanel firstPanel;
    private JLabel firstLabel;
    private JLabel icon1stLabel;
    private JPanel secondPanel;
    private JLabel secondLabel;
    private JLabel icon2ndLabel;
    private JLabel exchangeRate;
    private JButton[] keyButton = new JButton[15];

    private final String[] dataList = {"Byte", "KB", "MB", "GB", "TB", "PB"};
    private Border etchedBorder;
    private int gx = 0,gy = 3;

    public DataView(){
        initComponent();
    }

    private void initComponent(){

        this.setLayout(new GridBagLayout());

        // instantiate obj
        c = new GridBagConstraints();
        etchedBorder = new EtchedBorder();
        firstComboBox = new combo_suggestion.ComboBoxSuggestion();
        secondComboBox = new combo_suggestion.ComboBoxSuggestion();
        firstPanel = new JPanel(new BorderLayout());
        secondPanel = new JPanel(new BorderLayout());
        firstLabel = new JLabel("0", JLabel.RIGHT);
        secondLabel = new JLabel("0", JLabel.RIGHT);
        icon1stLabel = new JLabel(new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/image/riel.png"))), JLabel.LEFT);
        icon2ndLabel = new JLabel(new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("/image/dollar.png"))), JLabel.LEFT);
        exchangeRate = new JLabel("Exchange Rates: 1 Byte = 0.0009765 KB");

        // set font for combobox and label
        firstComboBox.setFont(new Font("Itim", Font.ITALIC, 15));
        secondComboBox.setFont(new Font("Itim", Font.ITALIC, 15));
        firstLabel.setFont(new Font("Itim", Font.BOLD, 50));
        secondLabel.setFont(new Font("Itim", Font.BOLD, 50));
        exchangeRate.setFont(new Font("Itim", Font.BOLD, 20));

        // add label to panel
        firstPanel.add(firstComboBox, BorderLayout.PAGE_START);
        firstPanel.add(icon1stLabel, BorderLayout.WEST);
        firstPanel.add(firstLabel, BorderLayout.EAST);
        secondPanel.add(secondComboBox, BorderLayout.PAGE_START);
        secondPanel.add(icon2ndLabel, BorderLayout.WEST);
        secondPanel.add(secondLabel, BorderLayout.EAST);
        firstPanel.setBorder(BorderFactory.createMatteBorder(3, 5, 3, 5, Color.BLACK));
        secondPanel.setBorder(BorderFactory.createMatteBorder(0, 5, 3, 5, Color.BLACK));

        exchangeRate.setBorder(BorderFactory.createMatteBorder(0, 5, 3, 5, Color.BLACK.brighter()));

        // set properties
        firstPanel.setBackground(new Color(199, 199, 199));
        secondPanel.setBackground(new Color(199, 199, 199));

        firstComboBox.setEditable(false);
        firstComboBox.setModel(new javax.swing.DefaultComboBoxModel(dataList));
        firstComboBox.setFocusable(false);
        secondComboBox.setEditable(false);
        secondComboBox.setModel(new javax.swing.DefaultComboBoxModel(dataList));
        secondComboBox.setFocusable(false);
        secondComboBox.setSelectedIndex(1);

        // customize constraint for label
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(firstPanel, c);

        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(secondPanel, c);

        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(exchangeRate, c);

        createKey();
    }

    private void createKey() { // src/image/icon-standard/Plus.png    || i == 15 || i == 19
        String[] buttonIconStandard = {"swap", "CE", "src/image/icon-standard/delete.png", "7", "8", "9", "4", "5"
                , "6", "1", "2", "3", "00", "0", "."};
        for (int i = 0; i < 15; i++) {

            if (i == 2) {
                keyButton[i] = new JButton(new ImageIcon(buttonIconStandard[i]));
            }
            else {
                keyButton[i] = new JButton(buttonIconStandard[i]);
                keyButton[i].setFont(new Font("Itim", Font.PLAIN, 35));
            }
            keyButton[i].setFocusable(false);
            keyButton[i].setBackground(new Color(199, 199, 199));
            keyButton[i].addActionListener(this);

            keyButton[i].setBorder(etchedBorder);

            if (gx == 3) {
                gx = 0;
                gy++;
            }
            c.gridx = gx;
            c.gridy = gy;
            c.gridwidth = 1;
            c.gridheight = 1;
            gx++;

            this.add(keyButton[i], c);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
