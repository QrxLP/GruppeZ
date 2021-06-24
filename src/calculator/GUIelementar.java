package calculator;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.format.FormatStyle;

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

    double lastDouble = 0.0;





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
                doFormating(input1);
            }
        });

        input2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                doFormating(input2);
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


        ACButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1.setText(null);
                input2.setText(null);
            }
        });
    }

    private void doFormating(JTextField field) {
        String text = field.getText();
        if (text.isEmpty() ){
            return;
        };


        try {
            lastDouble = Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            field.setText(String.valueOf(lastDouble));
        }
    }


}
