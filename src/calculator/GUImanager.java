package calculator;

import javax.swing.*;


public class GUImanager extends JFrame {

    GUIelementar  guiElementar;
    private JPanel rootPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public  static void main (String[] args){

        new GUImanager();

    }

    GUImanager(){
        //guiElementar = new GUIelementar();
        setVisible(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 400);

        add(rootPanel);
    }
}
