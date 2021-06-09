package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    GUIscalar(){
        add(rootPanel);
        setSize(400, 400 );
        setLocationRelativeTo(null);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}

