package calculator;

import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
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




    public GUIpythagoras() {

        setTitle("Satz des Pythagoras");

        setLocationRelativeTo(null);

        katheteATextField.setText("");
        katheteATextField.setText("");
        hypothenuseTextField.setText("");

        setSize(400,400);

        enter.setBorderPainted(false);

        JButton enterButton = new JButton("Enter");
        getRootPane().setDefaultButton(enterButton);

        add(rootPanel);

        readAndCalc();


    }

    private void readAndCalc(){
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        ActionMap actionMap = new ActionMapUIResource();
        actionMap.put("action_enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        InputMap keyMap = new ComponentInputMap(rootPanel);
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,
                0), "action_enter");
        SwingUtilities.replaceUIActionMap(rootPanel, actionMap);
        SwingUtilities.replaceUIInputMap(rootPanel, JComponent.WHEN_IN_FOCUSED_WINDOW,
                keyMap);
    }

    private void calculate(){
        Color resultColor= new Color(4,135,217);
        Color textColor=new Color(184,184,184);

        try {
            double[] param = new double[4];
            param[0] = 7;
            katheteATextField.setForeground(textColor); //changes the color back to the default text color, important for consecutive calculations
            katheteBTextField.setForeground(textColor);
            hypothenuseTextField.setForeground(textColor);

            //first input jTextField is empty, the others not
            if (katheteATextField.getText().equals("") && !katheteBTextField.getText().equals("") && !hypothenuseTextField.getText().equals("")) {
                param[1] = Double.parseDouble(hypothenuseTextField.getText());
                param[2] = 0;
                param[3] = Double.parseDouble(katheteBTextField.getText());
                double[] out = Logic.calc(param);
                double outNumber = (Math.round(out[0] * 100.0) / 100.0);
                katheteATextField.setText(String.valueOf(outNumber));
                katheteATextField.setForeground(resultColor);
            }
            //second input jTextField is empty, the others not
            else if (katheteBTextField.getText().equals("") && !katheteATextField.getText().equals("") && !hypothenuseTextField.getText().equals("")) {
                param[1] = Double.parseDouble(hypothenuseTextField.getText());
                param[2] = Double.parseDouble(katheteATextField.getText());
                param[3] = 0;
                double[] out = Logic.calc(param);
                double outNumber = (Math.round(out[0] * 100.0) / 100.0);
                katheteBTextField.setText(String.valueOf(outNumber));
                katheteBTextField.setForeground(resultColor);
            }
            //third input jTextField is empty, the others not
            else if (hypothenuseTextField.getText().equals("") && !katheteATextField.getText().equals("") && !katheteBTextField.getText().equals("")) {
                param[1] = 0;
                param[2] = Double.parseDouble(katheteATextField.getText());
                param[3] = Double.parseDouble(katheteBTextField.getText());
                double[] out = Logic.calc(param);
                double outNumber = (Math.round(out[0] * 100.0) / 100.0);
                hypothenuseTextField.setText(String.valueOf(outNumber));
                hypothenuseTextField.setForeground(resultColor);
            }
            //multiple input jTextFields are empty or all are full
            else {
                katheteATextField.setText("");
                katheteBTextField.setText("");
                hypothenuseTextField.setText("");
            }
        } catch (NumberFormatException | NullPointerException ex1) {
            ex1.printStackTrace();
            System.out.println("No input was found at one or more fields or Input is not " +
                    "a double!");

        } catch (ArrayIndexOutOfBoundsException ex2) {
            ex2.printStackTrace();
            System.out.println("Array out of bounds.");
        }
    }
}