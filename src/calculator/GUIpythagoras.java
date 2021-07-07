package calculator;

import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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
    private JButton ACButton;
    private Double lastDoubleKatheteA = 0.0;
    private Double lastDoubleKatheteB = 0.0;
    private Double lastDoubleKHypotenuse = 0.0;
    private final Color TEXT_COLOR = new Color(184,184,184);
    private final Color RESULT_COLOR = new Color(4,135,217);



    public GUIpythagoras() {

        setTitle("Satz des Pythagoras");

        setLocationRelativeTo(null);

        katheteATextField.setText("");
        katheteBTextField.setText("");
        hypothenuseTextField.setText("");

        setSize(400,400);

        enter.setBorderPainted(false);
        ACButton.setBorderPainted(false);

        add(rootPanel);


        katheteATextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoubleKatheteA = doFormating(katheteATextField, lastDoubleKatheteA);
            }
        });
        katheteBTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoubleKatheteB = doFormating(katheteBTextField, lastDoubleKatheteB);
            }
        });
        hypothenuseTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoubleKHypotenuse = doFormating(hypothenuseTextField, lastDoubleKHypotenuse );
            }
        });

        readAndCalc();


    }

    private void readAndCalc(){
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        ACButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ACAction();
            }
        });

        ActionMap actionMap = new ActionMapUIResource();
        actionMap.put("action_enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        actionMap.put("action_acbutton", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ACAction();
            }
        });

        InputMap keyMap = new ComponentInputMap(rootPanel);
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,
                0), "action_enter");
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE,
                0), "action_acbutton");
        SwingUtilities.replaceUIActionMap(rootPanel, actionMap);
        SwingUtilities.replaceUIInputMap(rootPanel, JComponent.WHEN_IN_FOCUSED_WINDOW,
                keyMap);
    }

    private void calculate(){

        try {
            double[] param = new double[4];
            param[0] = 7;
            katheteATextField.setForeground(TEXT_COLOR); //changes the color back to the default text color, important for consecutive calculations
            katheteBTextField.setForeground(TEXT_COLOR);
            hypothenuseTextField.setForeground(TEXT_COLOR);

            //first input jTextField is empty, the others not
            if (katheteATextField.getText().equals("") && !katheteBTextField.getText().equals("") && !hypothenuseTextField.getText().equals("")) {
                param[1] = Double.parseDouble(hypothenuseTextField.getText());
                param[2] = 0;
                param[3] = Double.parseDouble(katheteBTextField.getText());
                double[] out = Logic.calc(param);
                double outNumber = (Math.round(out[0] * 100.0) / 100.0);
                katheteATextField.setText(String.valueOf(outNumber));
                katheteATextField.setForeground(RESULT_COLOR);
            }
            //second input jTextField is empty, the others not
            else if (katheteBTextField.getText().equals("") && !katheteATextField.getText().equals("") && !hypothenuseTextField.getText().equals("")) {
                param[1] = Double.parseDouble(hypothenuseTextField.getText());
                param[2] = Double.parseDouble(katheteATextField.getText());
                param[3] = 0;
                double[] out = Logic.calc(param);
                double outNumber = (Math.round(out[0] * 100.0) / 100.0);
                katheteBTextField.setText(String.valueOf(outNumber));
                katheteBTextField.setForeground(RESULT_COLOR);
            }
            //third input jTextField is empty, the others not
            else if (hypothenuseTextField.getText().equals("") && !katheteATextField.getText().equals("") && !katheteBTextField.getText().equals("")) {
                param[1] = 0;
                param[2] = Double.parseDouble(katheteATextField.getText());
                param[3] = Double.parseDouble(katheteBTextField.getText());
                double[] out = Logic.calc(param);
                double outNumber = (Math.round(out[0] * 100.0) / 100.0);
                hypothenuseTextField.setText(String.valueOf(outNumber));
                hypothenuseTextField.setForeground(RESULT_COLOR);
            }
            //multiple input jTextFields are empty or all are full
            else {
                katheteATextField.setText("");
                katheteBTextField.setText("");
                hypothenuseTextField.setText("");
            }
        } catch (NumberFormatException ex1) {
            ex1.printStackTrace();
            System.out.println("Input is not a double!");

        }catch (NullPointerException ex2){
            ex2.printStackTrace();
            System.out.println("No input was found at one or more fields");
        }
        catch (ArrayIndexOutOfBoundsException ex3) {
            ex3.printStackTrace();
            System.out.println("Array out of bounds.");
        }
    }

    private void ACAction(){
        katheteATextField.setText("");
        katheteBTextField.setText("");
        hypothenuseTextField.setText("");
        katheteATextField.setForeground(TEXT_COLOR);
        katheteBTextField.setForeground(TEXT_COLOR);
        hypothenuseTextField.setForeground(TEXT_COLOR);
    }

    private double doFormating(JTextField field, double lastDouble) {
        String text = field.getText();
        if (text.isEmpty() ){
            return 0.0;
        };


        try {
            lastDouble = Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            field.setText(String.valueOf(lastDouble));
        }
        return lastDouble;
    }
}