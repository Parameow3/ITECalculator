package view;

import javax.swing.*;
import java.awt.*;

public class MainWindowView extends JFrame {

    public MainWindowView() {

        this.setSize(562, 768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);


        this.add(new CalculatorView());


        this.add(new StandardView());
        //this.add(new ScientificView());



        this.setBackground(new Color(234, 234, 234));
        this.setVisible(true);
    }
}
