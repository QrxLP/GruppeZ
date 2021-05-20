package calculator;

import javax.swing.*;

public class GUIpythagoras extends JFrame {
    private JPanel rootPanel;
    private JTextField katheteATextField;
    private JTextField katheteBTextField;
    private JTextField hypothenuseTextField;
    private JLabel katheteALabel;
    private JLabel katheteBLabel;
    private JLabel hypothenuseLabel;
    private JButton button1;

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