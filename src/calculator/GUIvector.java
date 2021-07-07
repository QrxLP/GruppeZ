package calculator;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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
    private JButton ACButton;
    private Double lastDoublea1 = 0.0;
    private Double lastDoubleb1 = 0.0;
    private Double lastDoublec1 = 0.0;
    private Double lastDoublea2 = 0.0;
    private Double lastDoubleb2 = 0.0;
    private Double lastDoublec2 = 0.0;

    private final Color TEXT_COLOR = new Color(184,184,184);
    private final Color RESULT_COLOR = new Color(4,135,217);


    GUIvector() {
        prepareGUI();
    }

    private void prepareGUI(){
        add(rootPanel);
        setTitle("Vektorprodukt");
        setLocationRelativeTo(null);
        setSize(400, 400);
        setVisible(false);

        enter.setBorderPainted(false);
        ACButton.setBorderPainted(false);

        a1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublea1 = doFormating (a1, lastDoublea1);
            }
        });
        b1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoubleb1 = doFormating (b1, lastDoubleb1);
            }
        });
        c1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublec1 = doFormating (c1, lastDoublec1);
            }
        });
        a2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublea2 = doFormating (a2, lastDoublea2);
            }
        });
        b2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoubleb2 = doFormating (b2, lastDoubleb2);
            }
        });
        c2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublec2 = doFormating (c2, lastDoublec2);
            }
        });

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
                    output = Logic.calc(input);
                    C1.setText(String.valueOf(output[0]));
                    C2.setText(String.valueOf(output[1]));
                    C3.setText(String.valueOf(output[2]));
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

    private  void ACAction(){
        a1.setText("");
        a2.setText("");
        b1.setText("");
        b2.setText("");
        c1.setText("");
        c2.setText("");
        C1.setText("");
        C2.setText("");
        C3.setText("");
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
