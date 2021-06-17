package calculator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class GUIvector extends JFrame {
    private JPanel rootPanel;
    private JTextField a1;
    private JTextField b1;
    private JTextField c1;
    private JTextField a2;
    private JTextField b2;
    private JTextField c2;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton enter;
    private JLabel leftBracketLabel;
    Logic logic;

    GUIvector() {
        setTitle("Vektorprodukt");
        setLocationRelativeTo(null);

        add(rootPanel);
        setSize(400, 400);
        setVisible(false);

        leftBracketLabel.setFont(new Font("Bracket",Font.BOLD,200));
        logic = new Logic();

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double input[] = new double[7];
                //Designation for Vectorproduct
                input[0] = 6;

                input[1] = Double.parseDouble(a1.getText());
                input[2] = Double.parseDouble(b1.getText());
                input[3] = Double.parseDouble(c1.getText());
                input[4] = Double.parseDouble(a2.getText());
                input[5] = Double.parseDouble(b2.getText());
                input[6] = Double.parseDouble(c2.getText());

                double[] output = new double[3];
                output = logic.calc(output);
            }
            });




    }



}
