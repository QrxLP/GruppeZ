package calculator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

public class GUIelementar extends JFrame implements PropertyChangeListener {

    private JPanel rootPanel;
    private JButton enter;
    private JButton add;
    private JButton sub;
    private JButton mult;
    private JButton diff;
    private JLabel operator;
    private JLabel output;
    private JFormattedTextField input1;
    private JTextField input2;
    private JButton ACButton;

    private int operatorNr;
    private Logic logic;

    private Double amount;
    private NumberFormat amountFormat;


    public GUIelementar()
    {

        setTitle("Elementarrechnung");
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400, 400);

        logic = new Logic();
        amount = 10000.00;
        setUpFormats();

        input1 = new JFormattedTextField(amountFormat);
        input1.setValue(new Double(amount));
        input1.setColumns(10);
        input1.addPropertyChangeListener("value", this);

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
        input1.addKeyListener(new KeyAdapter() {
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == input1) {
            amount = ((Number)input1.getValue()).doubleValue();
        }

    }

    private void setUpFormats() {
        amountFormat = NumberFormat.getNumberInstance();
    }
}
