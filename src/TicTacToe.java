import javax.swing.*;

public class TicTacToe extends JFrame {

    //single panel creation

    public static void main(String[] args) {
        int row1 = 3;
        int col1 = 3;
        JPanel totalGUI = new JPanel();
        Board board = new Board(totalGUI, row1,col1);
        JFrame frame = new JFrame("[=] GridLayout [=]");

        frame.setContentPane(board.createContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
