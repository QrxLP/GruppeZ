package calculator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {



    private Logic logic;
    private JPanel rootPanel;
    private JButton enter;
    private JTextField input1;
    private JTextField input2;
    private JButton add;
    private JButton sub;
    private JButton mult;
    private JButton diff;
    private JLabel operator;
    private JLabel output;
    private int operatorNr;

    public static void main (String args[]){

        new GUI();


    }

    public GUI()
    {

        logic = new Logic();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(rootPanel);
        setSize(400, 400);

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
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] param = new double[3];
                double[] out = new double[3];
                param[0] = operatorNr;

                param[1] = Double.parseDouble(input1.getText());
                param[2] = Double.parseDouble(input2.getText());

                out = logic.calc(param);

                output.setText(String.valueOf(out[0]));
            }
        });
    }

}
