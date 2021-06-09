package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIpythagoras extends JFrame {
    private JPanel rootPanel;
    private JTextField katheteATextField;
    private JTextField katheteBTextField;
    private JTextField hypothenuseTextField;
    private JLabel katheteALabel;
    private JLabel katheteBLabel;
    private JLabel hypothenuseLabel;
    private JButton Calculate;
    private Logic logic;

    public static void main(String[] args) {
        new GUIpythagoras();
    }

    public GUIpythagoras() {
        logic = new Logic();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(rootPanel);
        setSize(400,400);

        Calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] param =new double[4];
                param[0]=7;
                System.out.println("Calc");
                if(katheteATextField.getText().equals(""))
                {
                    System.out.println("A");
                    param[1]=0;
                    param[2]=Double.parseDouble(katheteBTextField.getText());
                    param[3]=Double.parseDouble(hypothenuseTextField.getText());
                    double[] out= logic.calc(param);
                    katheteATextField.setText(String.valueOf(out[0]));
                }
                else if(katheteBTextField.getText().equals(""))
                {
                    System.out.println("B");
                    param[1]=Double.parseDouble(katheteATextField.getText());
                    param[2]=0;
                    param[3]=Double.parseDouble(hypothenuseTextField.getText());
                    double[] out= logic.calc(param);
                    katheteBTextField.setText(String.valueOf(out[0]));
                }
                else if(hypothenuseTextField.equals(""))
                {
                    System.out.println("C");
                    param[1]=Double.parseDouble(katheteATextField.getText());
                    param[2]=Double.parseDouble(katheteBTextField.getText());
                    param[3]=0;
                    double[] out= logic.calc(param);
                    hypothenuseTextField.setText(String.valueOf(out[0]));
                }

            }
        });
    }

}