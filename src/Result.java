import javax.swing.*;
import java.awt.*;

public class Result {

    JPanel[][] arr;

    public Result(JPanel[][] arr){
        this.arr=arr;
    }

   public boolean check_rows_black()
    {
        System.out.println(this.arr);
        int i=0;
        int when_win;
            for (;i<arr.length;i++) {
                when_win=0;
                for (int j = 0; this.arr[i][j].getBackground() == Color.black; j++) {
                    when_win++;
                    if (when_win == arr.length) {
                        JOptionPane.showMessageDialog(null, "BLACK WON !!");
                        System.out.println("check_rows_black");
                        return true;
                    }
                }
            }
        return false;
    }

    public boolean check_rows_white()
    {
        System.out.println(this.arr);
        int i=0;
        for (;i<arr.length;i++) {
           int  when_win=0;
            for (int j = 0; this.arr[i][j].getBackground() == Color.white; j++) {
                when_win++;
                System.out.println("score = "+when_win);
                if (when_win == arr.length) {
                    JOptionPane.showMessageDialog(null, "WHITE WON!!");
                    System.out.println("check_rows_white");
                    System.out.println("SCORE"+when_win);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check_col_black()
    {
        int i=0;
        int when_win=0;
        for (;i<arr.length;i++) {
            int j=0;
            when_win=0;
            for (; this.arr[j][i].getBackground() == Color.black; j++) {
                when_win++;
                if (when_win == arr.length) {
                    JOptionPane.showMessageDialog(null, "BLACK WON !!");
                    System.out.println("check_col_black");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check_col_white()
    {
        int i=0;
        int when_win;
        for (;i<arr.length;i++) {
            when_win=0;
            for (int j = 0; this.arr[j][i].getBackground() == Color.white; j++) {
                when_win++;
                if (when_win == arr.length) {
                    JOptionPane.showMessageDialog(null, "WHITE WON !!");
                    System.out.println("check_col_white");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean result(){
        boolean wynik;
        if(wynik= check_col_black()) return true;
        if(wynik= check_rows_black()) return true;
        if(wynik= check_slant1_black()) return true;
        if(wynik= check_slant2_black()) return true;
        if(wynik= check_col_white()) return true;
        if(wynik= check_rows_white()) return true;
        if(wynik= check_slant1_white()) return true;
        if(wynik= check_slant2_white()) return true;
        return false;
    }

    public boolean check_slant1_black(){
        int when_win=0;
        int j=0;
        int i = arr.length-1;
        for (;i>=0;i--) {
            if(this.arr[j][i].getBackground() == Color.black){
                j++;
                when_win++;
                if (when_win == arr.length) {
                    JOptionPane.showMessageDialog(null, "BLACK WON !!");
                    System.out.println("check_slant1_black");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check_slant1_white(){
        int when_win=0;
        int j=0;
        int i = arr.length-1;
        for (;i>=0;i--) {
            if(this.arr[j][i].getBackground() == Color.white){
                j++;
                when_win++;
                if (when_win == arr.length) {
                    JOptionPane.showMessageDialog(null, "WHITE WON !!");
                    System.out.println("check_slant1_white");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check_slant2_black(){
        int when_win=0;
        for (int j = 0; this.arr[j][j].getBackground() == Color.black; j++) {
            when_win++;
            if (when_win == arr.length) {
                JOptionPane.showMessageDialog(null, "BLACK WON!!");
                System.out.println("check_slant2_black");
                return true;
            }
        }
        return false;
    }

    public boolean check_slant2_white(){
        int when_win=0;
        for (int j = 0; this.arr[j][j].getBackground() == Color.white; j++) {
            when_win++;
            if (when_win == arr.length) {
                JOptionPane.showMessageDialog(null, "WHITE WON !!");
                System.out.println("check_slant2_white");
                return true;
            }
        }
        return false;
    }
}


