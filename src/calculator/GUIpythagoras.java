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
    private JButton enter;
    private Logic logic;

    public static void main(String[] args) {
        new GUIpythagoras();
    }

    public GUIpythagoras() {

        setTitle("Satz des Pythagoras");
        logic = new Logic();
        setLocationRelativeTo(null);
        Color resultColor= new Color(4,135,217);
        Color textColor=new Color(184,184,184);

        katheteATextField.setText("");
        katheteATextField.setText("");
        hypothenuseTextField.setText("");

        setSize(400,400);

        enter.setMnemonic(KeyEvent.VK_ENTER);
        enter.setBorderPainted(false);

        JButton enterButton = new JButton("Enter");
        getRootPane().setDefaultButton(enterButton);

        add(rootPanel);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] param =new double[4];
                param[0]=7;
                katheteATextField.setForeground(textColor); //changes the color back to the default text color, important for consecutive calculations
                katheteBTextField.setForeground(textColor);
                hypothenuseTextField.setForeground(textColor);

                //first input jTextField is empty, the others not
                if(katheteATextField.getText().equals("") && !katheteBTextField.getText().equals("") && !hypothenuseTextField.getText().equals(""))
                {
                    param[1]=Double.parseDouble(hypothenuseTextField.getText());
                    param[2]=0;
                    param[3]=Double.parseDouble(katheteBTextField.getText());
                    double[] out= logic.calc(param);
                    double outNumber =(Math.round(out[0] * 100.0) / 100.0);
                    katheteATextField.setText(String.valueOf(outNumber));
                    katheteATextField.setForeground(resultColor);
                }
                //second input jTextField is empty, the others not
                else if(katheteBTextField.getText().equals("") && !katheteATextField.getText().equals("") && !hypothenuseTextField.getText().equals(""))
                {
                    param[1]=Double.parseDouble(hypothenuseTextField.getText());
                    param[2]=Double.parseDouble(katheteATextField.getText());
                    param[3]=0;
                    double[] out= logic.calc(param);
                    double outNumber =(Math.round(out[0] * 100.0) / 100.0);
                    katheteBTextField.setText(String.valueOf(outNumber));
                    katheteBTextField.setForeground(resultColor);
                }
                //third input jTextField is empty, the others not
                else if(hypothenuseTextField.getText().equals("") && !katheteATextField.getText().equals("") && !katheteBTextField.getText().equals(""))
                {
                    param[1]=0;
                    param[2]=Double.parseDouble(katheteATextField.getText());
                    param[3]=Double.parseDouble(katheteBTextField.getText());
                    double[] out= logic.calc(param);
                    double outNumber =(Math.round(out[0] * 100.0) / 100.0);
                    hypothenuseTextField.setText(String.valueOf(outNumber));
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
        Action pressEnter = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action Performed");
            }
        };
        rootPanel.getInputMap(2).put(KeyStroke.getKeyStroke("b"),"pressedEnter");
        rootPanel.getActionMap().put("enterPressed",pressEnter);
    }

}