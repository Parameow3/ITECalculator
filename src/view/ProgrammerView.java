package view;

import javax.swing.*;
import java.awt.*;

public class ProgrammerView extends JPanel {

    private JButton[] keyButton = new JButton[48];

    public ProgrammerView() {
        this.setSize(540, 413);
        this.setLocation(4, 320);
        this.setLayout(new GridLayout(8, 6, 2, 2));

        addButton();

        this.setBackground(new Color(234, 234, 234));

    }

    private void addButton() {

        String[] buttonIcon = {"set", "(", ")", "CE", "C", "src/image/icon-scientific/delete-small.png",
                "src/image/icon-scientific/arrow.png", "1/x", "src/image/icon-scientific/sin-1.png",
                "src/image/icon-scientific/cos-1.png", "src/image/icon-scientific/tan-1.png",
                "src/image/icon-scientific/pi.png", "src/image/icon-scientific/union.png",
                "src/image/icon-scientific/cubic.png", "sin", "cos", "tan", "e",
                "src/image/icon-scientific/intersection.png", "src/image/icon-scientific/log10.png",
                "ln", "n!", "%", "src/image/icon-scientific/divide-small.png",
                "src/image/icon-scientific/difference.png",
                "src/image/icon-scientific/x-power-y.png", "7", "8", "9",
                "src/image/icon-scientific/multiply-small.png", "src/image/icon-scientific/e-power-x.png",
                "src/image/icon-scientific/square-root-small.png", "4", "5", "6",
                "src/image/icon-scientific/minus-small.png", "src/image/icon-scientific/10power-x.png",
                "src/image/icon-scientific/square2-small.png", "1", "2", "3",
                "src/image/icon-scientific/plus-small.png", "src/image/icon-scientific/2power-x.png",
                "src/image/icon-scientific/x-power-y.png", "mod", "0", ".",
                "src/image/icon-scientific/Equal-small.png"};
        for (int i = 0; i < 48; i++) {


            if (i == 5 || i == 6 || i == 8 || i == 9 ||
                    i == 10 || i == 11 || i == 12 || i == 13 ||
                    i == 18 || i == 19 || i == 23 || i == 24 ||
                    i == 25 || i == 29 || i == 30 || i == 31 ||
                    i == 35 || i == 36 || i == 37 || i == 41 ||
                    i == 42 || i == 43 || i == 47) {

                keyButton[i] = new JButton(new ImageIcon(buttonIcon[i]));
            } else {
                keyButton[i] = new JButton(buttonIcon[i]);
                keyButton[i].setFont(new Font("Inter", Font.BOLD, 32));
            }
            if (i == 15)
                keyButton[i].setFont(new Font("Inter", Font.BOLD, 30));
            if (i == 44)
                keyButton[i].setFont(new Font("Inter", Font.BOLD, 24));
            keyButton[i].setFocusable(false);
            keyButton[i].setBackground(new Color(199, 199, 199));

            this.add(keyButton[i]);
        }
    }
}
