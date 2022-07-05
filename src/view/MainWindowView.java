package view;

import javax.swing.*;
import java.awt.*;

public class MainWindowView extends JFrame {

    public MainWindowView() {

        this.setSize(562, 768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        this.add(new CalculatorView(), BorderLayout.NORTH);


        //this.add(new StandardView(), BorderLayout.SOUTH);
        this.add(new ScientificView(), BorderLayout.SOUTH);



        this.setBackground(new Color(234, 234, 234));
        this.setVisible(true);
    }
}
