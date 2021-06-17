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
    private JTextField C1;
    private JTextField C2;
    private JTextField C3;
    private JButton enter;
    private JLabel leftBracketLabel;

    Logic logic;

    GUIvector() {
        setTitle("Vektorprodukt");
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400, 400);

        logic = new Logic();

        leftBracketLabel.setFont(new Font("Bracket",Font.BOLD,200));


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
                output = logic.calc(input);
                C1.setText(String.valueOf(output[0]));
                C2.setText(String.valueOf(output[1]));
                C3.setText(String.valueOf(output[2]));
            }
            });




    }



}
