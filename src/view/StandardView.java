package view;

import javax.swing.*;
import java.awt.*;

public class StandardView extends JPanel {

    private JButton[] keyButton = new JButton[24];
    public StandardView() {

        //this.setSize(540, 413);
        //this.setLocation(4, 315);
        this.setPreferredSize(new Dimension(540, 413));
        this.setLayout(new GridLayout(6, 4, 4, 6));

        addButton();

        this.setBackground(new Color(234, 234, 234));
    }

    private void addButton() {
        String[] buttonIcon = {"%", "CE", "C", "src/image/icon-standard/delete.png", "1/x",
                                "src/image/icon-standard/square2.png", "src/image/icon-standard/squareRoot.png",
                                "src/image/icon-standard/divide.png", "7", "8", "9",
                                "src/image/icon-standard/multiply.png", "4", "5", "6",
                                "src/image/icon-standard/minus.png",
                                "1", "2", "3", "src/image/icon-standard/Plus.png", "mod", "0", "." ,
                                "src/image/icon-standard/Equal.png"};
        for (int i = 0; i < 24; i++) {

            if (i == 3 || i == 5 || i == 6 || i == 7 ||
                i == 11 || i == 15 || i == 19 || i == 23) {

                keyButton[i] = new JButton(new ImageIcon(buttonIcon[i]));
            }
            else {
                keyButton[i] = new JButton(buttonIcon[i]);
                keyButton[i].setFont(new Font("Inter", Font.BOLD, 45));
            }
            keyButton[i].setFocusable(false);
            keyButton[i].setBackground(new Color(199, 199, 199));
            this.add(keyButton[i]);
        }
    }
}
