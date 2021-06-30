package calculator;
import javax.swing.*;
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
    private Logic logic;

    double lastDouble1 = 0.0;
    double lastDouble2 = 0.0;





    public GUIelementar()
    {



        setTitle("Elementarrechnung");
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400, 400);

        logic = new Logic();

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
        enter.setMnemonic(KeyEvent.VK_ENTER);
        add.setBorderPainted(false);
        add.setMnemonic(KeyEvent.VK_ADD);
        sub.setBorderPainted(false);
        sub.setMnemonic(KeyEvent.VK_SUBTRACT);
        mult.setBorderPainted(false);
        mult.setMnemonic(KeyEvent.VK_MULTIPLY);
        diff.setBorderPainted(false);
        diff.setMnemonic(KeyEvent.VK_DIVIDE);
        ACButton.setBorderPainted(false);
        ACButton.setMnemonic(KeyEvent.VK_ESCAPE);




        //todo farmattet text field

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operatorNr= 0;
                operator.setText("+");
            }
        });
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operatorNr = 1;
                operator.setText("-");
            }
        });
        mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operatorNr = 2;
                operator.setText("*");
            }
        });
        diff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operatorNr = 3;
                operator.setText("/");
            }
        });

        readAndCalc();
    }

    private void readAndCalc(){
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] param = new double[3];
                    double[] out = new double[3];

                    param[0] = operatorNr;
                    param[1] = Double.parseDouble(input1.getText());
                    param[2] = Double.parseDouble(input2.getText());

                    out = logic.calc(param);
                    output.setText(String.valueOf(out[0]));

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



        ACButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1.setText(null);
                input2.setText(null);
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
