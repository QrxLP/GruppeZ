package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUImanager extends JFrame {

    GUIelementar  guiElementar;
    GUIpythagoras guiPythagoras;
    GUIscalar  guiScalar;
    GUIvector guiVector;
    midnightFormula guiMidnightFormular;
    private JPanel rootPanel;
    private JButton buttonElementar;
    private JButton buttonPythagoras;
    private JButton buttonVektorPr;
    private JButton buttonScalarPr;
    private JButton buttonMidnight;


    public  static void main (String[] args){

        new GUImanager();

    }

    GUImanager(){
        //initialisieren der JFrames für die verschiedenen Berechnungen
        guiElementar = new GUIelementar();
        guiPythagoras = new GUIpythagoras();
        guiScalar = new GUIscalar();
        guiVector = new GUIvector();
        guiMidnightFormular = new midnightFormula();


        //diese GUI immer sichbar
        setVisible(true);

        //diese GUI beendet das Program beim schließen
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //öffnet sich in der Mitte
        setLocationRelativeTo(null);

        //größe auf 400, 400
        setSize(400, 400);

        //icon zu einem taschenrechner
        ImageIcon img = new ImageIcon("icon.png");
        setIconImage(img.getImage());




        //die Button schöner machen
        buttonElementar.setFocusPainted(false);
        buttonElementar.setBorderPainted(false);

        buttonPythagoras.setFocusPainted(false);
        buttonPythagoras.setBorderPainted(false);

        buttonScalarPr.setFocusPainted(false);
        buttonScalarPr.setBorderPainted(false);

        buttonVektorPr.setFocusPainted(false);
        buttonVektorPr.setBorderPainted(false);

        buttonMidnight.setFocusPainted(false);
        buttonMidnight.setBorderPainted(false);

        //per default alle anderen frames unschichtbar machen
        guiElementar.setVisible(false);
        guiPythagoras.setVisible(false);
        guiScalar.setVisible(false);
        guiVector.setVisible(false);
        guiMidnightFormular.setVisible(false);

        //gui.fomrm und Gui,java verbinden
        add(rootPanel);


        //ActionListener für alle auswahlmöglichkeiten
        //jeweils den ausgewählten Frame sichtbar und die andern unsichtbar machen
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
                guiMidnightFormular.setVisible(false);
            }
        });

        buttonVektorPr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(false);
                guiPythagoras.setVisible(false);
                guiScalar.setVisible(false);
                guiVector.setVisible(true);
                guiMidnightFormular.setVisible(false);
            }
        });

        buttonScalarPr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(false);
                guiPythagoras.setVisible(false);
                guiScalar.setVisible(true);
                guiVector.setVisible(false);
                guiMidnightFormular.setVisible(false);
            }
        });
        buttonMidnight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiElementar.setVisible(false);
                guiPythagoras.setVisible(false);
                guiScalar.setVisible(false);
                guiVector.setVisible(false);
                guiMidnightFormular.setVisible(true);
            }
        });
    }


}
