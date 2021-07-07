package calculator;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        enter.setMnemonic(KeyEvent.VK_ENTER);
    }

    private void readAndcalc(){
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
        } catch (NumberFormatException | NullPointerException ex1) {
            ex1.printStackTrace();
            System.out.println("No input was found at one or more fields or Input is not " +
                    "a double!");

        } catch (ArrayIndexOutOfBoundsException ex2) {
            ex2.printStackTrace();
            System.out.println("Array out of bounds.");
        }

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
