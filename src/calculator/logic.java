package calculator;

import javax.swing.*;

public class logic {

    static GUI gui;

    logic()
    {

    }

    public static void main (String args[]){

        gui = new GUI();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
