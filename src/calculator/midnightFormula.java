package calculator;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class midnightFormula extends JFrame{
    private JPanel rootPanel;
    private JButton enter;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel resultPossibleLabel;
    private JButton ACButton;
    private Double lastDoublea1 = 0.0;
    private Double lastDoublea2 = 0.0;
    private Double lastDoublea3 = 0.0;

    private final Color TEXT_COLOR = new Color(184,184,184);
    private final Color RESULT_COLOR = new Color(4,135,217);

    public midnightFormula(){
        prepareGUI();
        readAndcalc();
    }

    private void prepareGUI(){
        add(rootPanel);
        setTitle("Mitternachtsformel");
        setLocationRelativeTo(null);
        setSize(400,400);
        setVisible(false);

        resultPossibleLabel.setVisible(false);
        enter.setBorderPainted(false);
        ACButton.setBorderPainted(false);

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublea1 = doFormating (textField1, lastDoublea1);
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublea2 = doFormating (textField2, lastDoublea2);
            }
        });
        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublea3 = doFormating (textField3, lastDoublea3);
            }
        });

    }

    private void readAndcalc(){
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
        try{
            double [] input = new double [4];
            input[0] = 4;

            input[1] = Double.parseDouble(textField1.getText());
            input[2] = Double.parseDouble(textField2.getText());
            input[3] = Double.parseDouble(textField3.getText());



            double[] output = Logic.calc(input);
            if(output[2] == 1) {
                textField4.setText("N/A");
                textField5.setText("N/A");
                resultPossibleLabel.setVisible(true);
            } else {
                textField4.setText(String.valueOf(output[0]));
                textField5.setText(String.valueOf(output[1]));
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

    private  void ACAction(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
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
