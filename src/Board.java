import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board implements ActionListener {

    JPanel totalGUI;
    JButton[][] button;
    JButton reset = new JButton("DRAW");

    int player=1;
    int moves=0;

    // We create a JPanel with the GridLayout.
    JPanel mainPanel;

    JPanel[][] arr;

    public void createBoard(int rows, int cols){
        this.mainPanel = new JPanel(new GridLayout(rows, cols, 10, 10));
        this.arr = new JPanel[rows][cols];
        this.button=new JButton[rows][cols];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                this.arr[i][j] = createSquareJPanel(Color.blue, 100);
                this.button[i][j] = new JButton("ROW: "+i+"COL "+j);
                this.button[i][j].addActionListener(this);
                this.arr[i][j].add(button[i][j]);
                this.mainPanel.add(arr[i][j]);
            }
        }
    }

    public JPanel createContentPane (){
        totalGUI.add(mainPanel);
        reset.addActionListener(this);
        totalGUI.add(reset);
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    private JPanel createSquareJPanel(Color color, int size)
    {
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(color);
        tempPanel.setMinimumSize(new Dimension(size, size));
        tempPanel.setMaximumSize(new Dimension(size, size));
        tempPanel.setPreferredSize(new Dimension(size, size));
        return tempPanel;
    }

    public void changeColor(Color color, int i, int j){
        System.out.println(this.arr[i][j].getColorModel());
        this.arr[i][j].getColorModel();
        this.arr[i][j].setBackground(color);
    }

    public void reset() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                changeColor(Color.blue,i,j);
            }
        }
        System.out.println("reset");
        moves=0;
    }

    public Board(JPanel totalGUI, int i, int j){
        this.totalGUI =  totalGUI;
        this.createBoard(i,j);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        moves++;
       // if(source==reset) reset();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if((source == this.button[i][j]) && (this.arr[i][j].getBackground() != Color.white)&&(this.arr[i][j].getBackground() != Color.black)){
                    if(player == 1){
                        changeColor(Color.white,i,j);
                        player++;
                    }

                    else{
                        changeColor(Color.black,i,j);
                        player--;
                    }
            }
        }
        }
        System.out.println("moves: "+moves);
        Result score = new Result(arr);
        score.result();
        if(moves==arr.length*arr.length && !score.result()){
            JOptionPane.showMessageDialog(null, "DRAW!!");
            reset();
        }
    }
}
