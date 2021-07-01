package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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




    GUIscalar(){

        setTitle("Skalarprodukt");
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
}

