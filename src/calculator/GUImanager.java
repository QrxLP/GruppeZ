package calculator;

import javax.swing.*;


public class GUImanager extends JFrame {

    GUIelementar  guiElementar;

    public  static void main (String[] args){

        new GUImanager();

    }

    GUImanager(){
        guiElementar = new GUIelementar();
        setVisible(true);

    }
}
