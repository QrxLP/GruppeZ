import javax.swing.*;

public class GUIallInOne extends JFrame {
    private JButton button1;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton zeroButton;
    private JPanel root;


    public static void main (String[] args){
        new GUIallInOne();

    }

    GUIallInOne(){
        add(root);
        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
