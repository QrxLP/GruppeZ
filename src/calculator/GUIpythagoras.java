package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
        setLocationRelativeTo(null);

        katheteATextField.setText("");
        katheteATextField.setText("");
        hypothenuseTextField.setText("");

        add(rootPanel);
        setSize(400,400);

        Calculate.setMnemonic(KeyEvent.VK_ENTER);

        Calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] param =new double[4];
                param[0]=7;
                if(katheteATextField.getText().equals("") && !katheteBTextField.getText().equals("") && !hypothenuseTextField.getText().equals(""))

                {
                    param[1]=Double.parseDouble(hypothenuseTextField.getText());
                    param[2]=0;
                    param[3]=Double.parseDouble(katheteBTextField.getText());
                    double[] out= logic.calc(param);
                    katheteATextField.setText(String.valueOf(out[0]));
                }
                else if(katheteBTextField.getText().equals("") && !katheteATextField.getText().equals("") && !hypothenuseTextField.getText().equals(""))
                {
                    param[1]=Double.parseDouble(hypothenuseTextField.getText());
                    param[2]=Double.parseDouble(katheteATextField.getText());
                    param[3]=0;
                    double[] out= logic.calc(param);
                    katheteBTextField.setText(String.valueOf(out[0]));
                }
                else if(hypothenuseTextField.getText().equals("") && !katheteATextField.getText().equals("") && !katheteBTextField.getText().equals(""))
                {
                    param[1]=0;
                    param[2]=Double.parseDouble(katheteATextField.getText());
                    param[3]=Double.parseDouble(katheteBTextField.getText());
                    double[] out= logic.calc(param);
                    hypothenuseTextField.setText(String.valueOf(out[0]));
                }
                else
                {
                    katheteATextField.setText("");
                    katheteBTextField.setText("");
                    hypothenuseTextField.setText("");
                }

            }
        });
    }

}