package calculator;
import javax.swing.*;
import java.awt.*;
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


    public GUIpythagoras() {

        setTitle("Sart des Pythagoras");
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400,400);

        logic = new Logic();

        katheteATextField.setText("");
        katheteATextField.setText("");
        hypothenuseTextField.setText("");

        Calculate.setMnemonic(KeyEvent.VK_ENTER);
        Calculate.setBorderPainted(false);

        Calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] param =new double[4];
                param[0]=7;
                Color resultColor= new Color(4,135,217);
                Color defaultColor=new Color(184,184,184);
                katheteATextField.setForeground(defaultColor); //changes the color back to the default text color, important for consecutive calculations
                katheteBTextField.setForeground(defaultColor);
                hypothenuseTextField.setForeground(defaultColor);

                //first input jTextField is empty, the others not
                if(katheteATextField.getText().equals("") && !katheteBTextField.getText().equals("") && !hypothenuseTextField.getText().equals(""))
                {
                    param[1]=Double.parseDouble(hypothenuseTextField.getText());
                    param[2]=0;
                    param[3]=Double.parseDouble(katheteBTextField.getText());
                    double[] out= logic.calc(param);
                    katheteATextField.setText(String.valueOf(out[0]));
                    katheteATextField.setForeground(resultColor);
                }
                //second input jTextField is empty, the others not
                else if(katheteBTextField.getText().equals("") && !katheteATextField.getText().equals("") && !hypothenuseTextField.getText().equals(""))
                {
                    param[1]=Double.parseDouble(hypothenuseTextField.getText());
                    param[2]=Double.parseDouble(katheteATextField.getText());
                    param[3]=0;
                    double[] out= logic.calc(param);
                    katheteBTextField.setText(String.valueOf(out[0]));
                    katheteBTextField.setForeground(resultColor);
                }
                //third input jTextField is empty, the others not
                else if(hypothenuseTextField.getText().equals("") && !katheteATextField.getText().equals("") && !katheteBTextField.getText().equals(""))
                {
                    param[1]=0;
                    param[2]=Double.parseDouble(katheteATextField.getText());
                    param[3]=Double.parseDouble(katheteBTextField.getText());
                    double[] out= logic.calc(param);
                    hypothenuseTextField.setText(String.valueOf(out[0]));
                    hypothenuseTextField.setForeground(resultColor);
                }
                //multiple input jTextFields are empty or all are full
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