package calculator;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIelementar extends JFrame {

    private JPanel rootPanel;
    private JButton enter;
    private JButton add;
    private JButton sub;
    private JButton mult;
    private JButton diff;
    private JLabel operator;
    private JLabel output;
    private JTextField input1;
    private JTextField input2;
    private JButton ACButton;
    private Formatting formatting;

    private int operatorNr;


    double lastDouble1 = 0.0;
    double lastDouble2 = 0.0;

    public GUIelementar()
    {



        setTitle("Elementarrechnung");
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400, 400);


        input1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDouble1 = doFormating (input1, lastDouble1);
            }
        });

        input2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDouble2 = doFormating(input2, lastDouble2);
            }
        });



        enter.setBorderPainted(false);
        add.setBorderPainted(false);
        sub.setBorderPainted(false);
        mult.setBorderPainted(false);
        diff.setBorderPainted(false);
        ACButton.setBorderPainted(false);

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
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAction();
            }
        });
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subAction();
            }
        });
        mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multAction();
            }
        });
        diff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diffAction();
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
        actionMap.put("action_add", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAction();
            }
        });
        actionMap.put("action_sub", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subAction();
            }
        });
        actionMap.put("action_mult", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multAction();
            }
        });
        actionMap.put("action_diff", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diffAction();
            }
        });

        InputMap keyMap = new ComponentInputMap(rootPanel);
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,
                0), "action_enter");
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE,
                0), "action_acbutton");
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ADD,
                0), "action_add");
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SUBTRACT,
                0), "action_sub");
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_MULTIPLY,
                0), "action_mult");
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DIVIDE,
                0), "action_diff");

        SwingUtilities.replaceUIActionMap(rootPanel, actionMap);
        SwingUtilities.replaceUIInputMap(rootPanel, JComponent.WHEN_IN_FOCUSED_WINDOW,
                keyMap);
    }
    private void calculate(){
        try {
            double[] param = new double[3];
            double[] out = new double[3];

            param[0] = operatorNr;
            param[1] = Double.parseDouble(input1.getText());
            param[2] = Double.parseDouble(input2.getText());

            out = Logic.calc(param);
            output.setText(String.valueOf(out[0]));

        }catch (NumberFormatException ex1) {
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
    private  void ACAction(){
        input1.setText(null);
        input2.setText(null);
        output.setText(null);
    }
    private void addAction(){
        operatorNr= 0;
        operator.setText("+");
    }
    private void subAction(){
        operatorNr = 1;
        operator.setText("-");
    }
    private void multAction(){
        operatorNr = 2;
        operator.setText("*");
    }
    private void diffAction(){
        operatorNr = 3;
        operator.setText("/");
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
