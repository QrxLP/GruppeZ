package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIscalar extends JFrame {

    private JPanel rootPanel;
    private JTextField a1TextField;
    private JTextField a2TextField;
    private JTextField a3TextField;
    private JTextField b1TextField;
    private JTextField b2TextField;
    private JTextField b3TextField;
    private JButton enterButton;
    private JLabel outputLabel;
    private JLabel outputLabel2;

    double lastDoublea1 = 0.0;
    double lastDoublea2 = 0.0;
    double lastDoublea3 = 0.0;
    double lastDoubleb1 = 0.0;
    double lastDoubleb2 = 0.0;
    double lastDoubleb3 = 0.0;


    GUIscalar(){
        prepareGUI();
        readAndCalc();

    }
    public void readAndCalc(){
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double[] temp;
                    temp = new double[7];

                    temp[0]=6;
                    temp[1] = Double.parseDouble(a1TextField.getText());
                    temp[2] = Double.parseDouble(a2TextField.getText());
                    temp[3] = Double.parseDouble(a3TextField.getText());
                    temp[4] = Double.parseDouble(b1TextField.getText());
                    temp[5] = Double.parseDouble(b2TextField.getText());
                    temp[6] = Double.parseDouble(b3TextField.getText());

                    outputLabel2.setText(String.valueOf(Math.toDegrees(Logic.calc(temp)[1])));
                } catch (NumberFormatException | NullPointerException ex1) {
                    ex1.printStackTrace();
                    System.out.println("No input was found at one or more fields or Input is not " +
                            "a double!");

                } catch (ArrayIndexOutOfBoundsException ex2) {
                    ex2.printStackTrace();
                    System.out.println("Array out of bounds.");
                }
            }
        });
    }

    private void prepareGUI(){
        setTitle("Skalarprodukt");
        setVisible(false);
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400, 400 );
        Color defaultColor=new Color(184,184,184);

        enterButton.setBorderPainted(false);
        enterButton.setMnemonic(KeyEvent.VK_ENTER);

        a1TextField.setCaretColor(defaultColor);
        a2TextField.setCaretColor(defaultColor);
        a3TextField.setCaretColor(defaultColor);

        b1TextField.setCaretColor(defaultColor);
        b2TextField.setCaretColor(defaultColor);
        b3TextField.setCaretColor(defaultColor);


        a1TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoublea1 = doFormating(a1TextField, lastDoublea1);
            }
        });
        a2TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoublea2 = doFormating(a2TextField, lastDoublea2);
            }
        });
        a3TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoublea3 = doFormating(a3TextField, lastDoublea3);
            }
        });

        b1TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoubleb1 = doFormating(b1TextField, lastDoubleb1);
            }
        });
        b2TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoubleb2 = doFormating(b2TextField, lastDoubleb2);
            }
        });
        b3TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoubleb3 = doFormating(b3TextField, lastDoubleb3);
            }
        });

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
