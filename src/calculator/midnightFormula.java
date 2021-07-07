package calculator;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Implementiert das GUI für die Berechnung mit der Mitternachtsformel und die Übergabe der Eingabewerte an Logic zur Berechnung
 *  */
public class midnightFormula extends JFrame{
    private JPanel rootPanel;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;

    private JLabel resultPossibleLabel;

    private JButton enter;
    private JButton ACButton;

    private Double lastDoublea1 = 0.0;
    private Double lastDoublea2 = 0.0;
    private Double lastDoublea3 = 0.0;

    public midnightFormula(){
        prepareGUI();
    }

    /**
     * Baut die GUI auf, d.h. konfiguriert gewisse JComponents und fügt KeyListener und ActionListener hinzu
     */
    private void prepareGUI(){
        add(rootPanel);
        setTitle("Mitternachtsformel");
        setLocationRelativeTo(null);
        setSize(400,400);
        setVisible(false);

        resultPossibleLabel.setVisible(false);
        enter.setBorderPainted(false);
        ACButton.setBorderPainted(false);

       //Fügt Keylistener hinzu. Wichtig für Formattierung der Eingabewerte
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublea1 = doFormating (textField1, lastDoublea1);
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublea2 = doFormating (textField2, lastDoublea2);
            }
        });
        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                lastDoublea3 = doFormating (textField3, lastDoublea3);
            }
        });

        //Fügt ActionListener, ActionMap und InputMap hinzu. Wichtig für Hotkeys
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        ACButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ACAction();
            }
        });

        ActionMap actionMap = new ActionMapUIResource();
        actionMap.put("action_enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        actionMap.put("action_acbutton", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ACAction();
            }
        });

        InputMap keyMap = new ComponentInputMap(rootPanel);
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,
                0), "action_enter");
        keyMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE,
                0), "action_acbutton");
        SwingUtilities.replaceUIActionMap(rootPanel, actionMap);
        SwingUtilities.replaceUIInputMap(rootPanel, JComponent.WHEN_IN_FOCUSED_WINDOW,
                keyMap);
    }

    /**
     * Übergibt die, in die JTextFields eingegebenen Werte an Logic zur Berechnung und zeigt das Ergebnis/die Ergebnisse in den Ausgabefeldern an.
     */
    private void calculate(){
        try{
            double [] input = new double [4];
            input[0] = 4; //Kennziffer für Mitternachtsformel

            input[1] = Double.parseDouble(textField1.getText());
            input[2] = Double.parseDouble(textField2.getText());
            input[3] = Double.parseDouble(textField3.getText());

            //output wird auf 2 Nachkommastellen gerundet
            double[] output = Logic.calc(input);
            double outNumber1 = (Math.round(output[0] * 100.0) / 100.0);
            double outNumber2 = (Math.round(output[1] * 100.0) / 100.0);

            if(output[2] == 1) {
                textField4.setText("N/A");
                textField5.setText("N/A");
                resultPossibleLabel.setVisible(true);
            } else {
                textField4.setText(String.valueOf(outNumber1));
                textField5.setText(String.valueOf(outNumber2));
            }
        } catch (NumberFormatException ex1) {
            ex1.printStackTrace();
            System.out.println("Input is not a double!");

        }catch (NullPointerException ex2){
            ex2.printStackTrace();
            System.out.println("No input was found at one or more fields");
        }
        catch (ArrayIndexOutOfBoundsException ex3) {
            ex3.printStackTrace();
            System.out.println("Array out of bounds.");
        }

    }

    /**
     * Leert alle Felder des Rechners
     */
    private  void ACAction(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
    }

    /**
     * Formatiert Eingabewerte, d.h. lässt nur double als Datentyp zu
     * @param field
     * @param lastDouble
     * @return double
     */
    private double doFormating(JTextField field, double lastDouble) {
        String text = field.getText();
        if (text.isEmpty() ){
            return 0.0;
        };


        try {
            lastDouble = Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            field.setText(String.valueOf(lastDouble));
        }
        return lastDouble;
    }
}
