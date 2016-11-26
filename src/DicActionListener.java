import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Eric on 2016/11/23.
 */
public class DicActionListener extends UI {
    private String text;
    private Client dicClient;
    public DicActionListener( Client dicClient) {
        this.dicClient=dicClient;

        //Listen key "enter"
        searchText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    text=searchText.getText();
                    if(!text.isEmpty()){
                        contentUpdate();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        //Listen search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text=searchText.getText();
                if(!text.isEmpty()){
                    contentUpdate();
                }
            }
        });

        //
    }

    public void contentUpdate() {
        if(!textChecker()) {
            setMessage(text + " is illegal.");
            return;
        }
        try{
            answer=dicClient.queryWord(text);
            setArea1(answer.get(0));
            if(answer.size()>1)
                setArea2(answer.get(1));
            if(answer.size()>2)
                setArea3(answer.get(2));
        }
        catch (Exception e)
        {
            //handle the exception
        }
    }

    boolean textChecker() {
        for(int i=0;i<text.length();++i) {
            if(!Character.isLetter(text.charAt(i)))
                return false;
        }
        return true;
    }

}
