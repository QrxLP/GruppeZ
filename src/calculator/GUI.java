package calculator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {


    private JPanel rootPanel;
    private JButton enter;
    private JTextField input1;
    private JTextField input2;
    private JButton add;
    private JButton sub;
    private JButton mult;
    private JButton diff;
    private JLabel operator;
    private int operatorNr;

    public GUI()
    {

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
    }

}
