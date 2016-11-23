import javax.swing.*;

/**
 * Created by Eric on 2016/11/23.
 */
public class Dictionary {
    public static void main(String[] args)throws Exception {
        DicActionListener dal=new DicActionListener();
        dal.InitializeTranslator();
        dal.setLocationRelativeTo(null);
        dal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
