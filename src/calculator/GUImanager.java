package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUImanager extends JFrame {

    GUIelementar  guiElementar;
    GUIpythagoras guiPythagoras;
    GUIscalar  guiScalar;
    private JPanel rootPanel;
    private JButton buttonElementar;
    private JButton buttonPythagoras;
    private JButton buttonVector;

    public  static void main (String[] args){

        new GUImanager();

    }

    GUImanager(){
        guiElementar = new GUIelementar();
        setVisible(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 400);

        add(rootPanel);

        buttonElementar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(true);
            }
        });

        buttonPythagoras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(false);
            }
        });

        buttonVector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(false);
            }
        });
    }


}
