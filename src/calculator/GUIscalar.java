package calculator;
import javax.swing.*;
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

    private Logic logic;


    GUIscalar(){

        setTitle("Skalarprodukt");
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400, 400 );

        logic = new Logic();

        enterButton.setBorderPainted(false);
        enterButton.setMnemonic(KeyEvent.VK_ENTER);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] temp;
                temp = new double[7];

                temp[0]=6;
                temp[1] = Double.parseDouble(a1TextField.getText());
                temp[2] = Double.parseDouble(a2TextField.getText());
                temp[3] = Double.parseDouble(a3TextField.getText());
                temp[4] = Double.parseDouble(b1TextField.getText());
                temp[5] = Double.parseDouble(b2TextField.getText());
                temp[6] = Double.parseDouble(b3TextField.getText());

                outputLabel.setText("Winkel: " + String.valueOf(Math.toDegrees(logic.calc(temp)[1])));
            }
        });
    }
}

