import javax.swing.*;

/**
 * Created by Eric on 2016/11/23.
 */
public class Main {
    public static void main(String[] args)throws Exception {
        Client dicClient=new Client();
        DicActionListener dal=new DicActionListener(dicClient);
        dal.setLocationRelativeTo(null);
        dal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
