package calculator;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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
    private JButton ACButton;

    private JLabel outputLabel2;
    private JLabel outputLable1;
    private JLabel outputLabel;

    double lastDoublea1 = 0.0;
    double lastDoublea2 = 0.0;
    double lastDoublea3 = 0.0;
    double lastDoubleb1 = 0.0;
    double lastDoubleb2 = 0.0;
    double lastDoubleb3 = 0.0;

    GUIscalar(){
        prepareGUI();
    }

    /**
     * Baut die GUI auf, d.h. konfiguriert gewisse JComponents und fügt KeyListener und ActionListener hinzu
     */
    private void prepareGUI(){
        setTitle("Skalarprodukt");
        setVisible(false);
        setLocationRelativeTo(null);
        add(rootPanel);
        setSize(400, 400 );

        enterButton.setBorderPainted(false);
        ACButton.setBorderPainted(false);

        //Fügt Keylistener hinzu. Wichtig für Formattierung der Eingabewerte
        a1TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoublea1 = doFormating(a1TextField, lastDoublea1);
            }
        });
        a2TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoublea2 = doFormating(a2TextField, lastDoublea2);
            }
        });
        a3TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoublea3 = doFormating(a3TextField, lastDoublea3);
            }
        });

        b1TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoubleb1 = doFormating(b1TextField, lastDoubleb1);
            }
        });
        b2TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoubleb2 = doFormating(b2TextField, lastDoubleb2);
            }
        });
        b3TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);
                lastDoubleb3 = doFormating(b3TextField, lastDoubleb3);
            }
        });

        //Fügt ActionListener, ActionMap und InputMap hinzu. Wichtig für Hotkeys
        enterButton.addActionListener(new ActionListener() {
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
            double[] temp;
            temp = new double[7];

            temp[0]=5;
            temp[1] = Double.parseDouble(a1TextField.getText());
            temp[2] = Double.parseDouble(a2TextField.getText());
            temp[3] = Double.parseDouble(a3TextField.getText());
            temp[4] = Double.parseDouble(b1TextField.getText());
            temp[5] = Double.parseDouble(b2TextField.getText());
            temp[6] = Double.parseDouble(b3TextField.getText());

            outputLabel2.setText(String.valueOf(Math.round(Logic.calc(temp)[1] *100.0) / 100.0));
            outputLable1.setText(String.valueOf(Math.round(Logic.calc(temp)[0] *100.0) / 100.0));
        } catch (NumberFormatException ex1) {
            ex1.printStackTrace();
            System.out.println("Input is not " +
                    "a double!");

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
        a1TextField.setText("");
        a2TextField.setText("");
        a3TextField.setText("");
        b1TextField.setText("");
        b2TextField.setText("");
        b3TextField.setText("");
        outputLabel2.setText("");
        outputLable1.setText("");


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
        }


        try {
            lastDouble = Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            field.setText(String.valueOf(lastDouble));
        }
        return lastDouble;
    }
}