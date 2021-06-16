package calculator;

import javax.swing.*;
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
    Logic logic;

    public midnightFormula(){
        logic = new Logic();
        setVisible(true);
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400,400);
        resultPossibleLabel.setVisible(false);

        enter.setBorderPainted(false);
        enter.setMnemonic(KeyEvent.VK_ENTER);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double [] input = new double [4];
                    input[0] = 4;
                try {
                    input[1] = Double.parseDouble(textField1.getText());
                    input[2] = Double.parseDouble(textField2.getText());
                    input[3] = Double.parseDouble(textField3.getText());
                }
                catch (NumberFormatException | NullPointerException nfe) {};


                double[] output = logic.calc(input);
                if(output[2] == 1) {
                    textField4.setText("N/A");
                    textField5.setText("N/A");
                    resultPossibleLabel.setVisible(true);
                } else {
                    textField4.setText(String.valueOf(output[0]));
                    textField5.setText(String.valueOf(output[1]));
                }


            }
        });


    }


}
