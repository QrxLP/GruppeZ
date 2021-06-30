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
        setTitle("Mitternachtsformel");
        logic = new Logic();
        setVisible(true);
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400,400);
        resultPossibleLabel.setVisible(false);

        enter.setBorderPainted(false);
        enter.setMnemonic(KeyEvent.VK_ENTER);

        readAndcalc();




    }

    private void readAndcalc(){
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double [] input = new double [4];
                    input[0] = 4;

                    input[1] = Double.parseDouble(textField1.getText());
                    input[2] = Double.parseDouble(textField2.getText());
                    input[3] = Double.parseDouble(textField3.getText());



                    double[] output = logic.calc(input);
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
        });
    }


}
