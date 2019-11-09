import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;
import java.awt.*;
import java.util.function.DoubleToIntFunction;

public class TicTacToe extends JFrame {

    //single panel creation

    public static void main(String[] args) {
        int row1 = 3;
        int col1 = 3;
        JPanel totalGUI = new JPanel();
        Kolko plansza = new Kolko(totalGUI, row1,col1);
        JFrame frame = new JFrame("[=] GridLayout [=]");

        frame.setContentPane(plansza.createContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
