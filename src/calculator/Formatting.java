package calculator;

import javax.swing.*;

public class Formatting {

    double lastDouble = 0.0;

    public void Format(JTextField field){


        String text = field.getText();
        if (text.isEmpty()) return;



        try {
            lastDouble = Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            field.setText(lastDouble + ""); // or set to other values you want
        }


    }


}
