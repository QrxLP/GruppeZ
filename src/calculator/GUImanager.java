package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUImanager extends JFrame {

    GUIelementar  guiElementar;
    GUIpythagoras guiPythagoras;
    GUIscalar  guiScalar;
    GUIvector guiVector;
    private JPanel rootPanel;
    private JButton buttonElementar;
    private JButton buttonPythagoras;
    private JButton buttonVektorPr;
    private JButton buttonScalarPr;

    public  static void main (String[] args){

        new GUImanager();

    }

    GUImanager(){
        guiElementar = new GUIelementar();
        guiPythagoras = new GUIpythagoras();
        guiScalar = new GUIscalar();
        guiVector = new GUIvector();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 400);
        guiElementar.setVisible(false);
        guiPythagoras.setVisible(false);
        guiScalar.setVisible(false);
        guiVector.setVisible(false);


        add(rootPanel);

        buttonElementar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(true);
                guiPythagoras.setVisible(false);
                guiScalar.setVisible(false);
                guiVector.setVisible(false);
            }
        });

        buttonPythagoras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(false);
                guiPythagoras.setVisible(true);
                guiScalar.setVisible(false);
                guiVector.setVisible(false);
            }
        });

        buttonVektorPr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(false);
                guiPythagoras.setVisible(false);
                guiScalar.setVisible(false);
                guiVector.setVisible(true);
            }
        });

        buttonScalarPr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(false);
                guiPythagoras.setVisible(false);
                guiScalar.setVisible(true);
                guiVector.setVisible(false);
            }
        });
    }


}
