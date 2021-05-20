package calculator;

import javax.swing.*;

public class GUIpythagoras extends JFrame {
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public static void main(String[] args) {
        new GUIpythagoras();
    }

    public GUIpythagoras() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(rootPanel);
        setSize(400,400);
    }

}