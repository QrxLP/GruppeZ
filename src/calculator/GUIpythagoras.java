package calculator;

import javax.swing.*;

public class GUIpythagoras extends JFrame {
    private JPanel rootPanel;
    private JTextPane katheteATextPane;
    private JTextPane textPane2;
    private JTextPane textPane3;

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