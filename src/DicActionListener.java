import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;

/**
 * Created by Eric on 2016/11/23.
 */
public class DicActionListener extends UI {
    private String text;
    public DicActionListener() {
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
    }

    public void contentUpdate() {
        if(!t.get(0).textChecker(text)) {
            setMessage(text+" is illeagal.");
            return;
        }
        sortTranslator();
        try{
            setArea1(t.get(0).getTranslation(text));
            setArea2(t.get(1).getTranslation(text));
            setArea3(t.get(2).getTranslation(text));
        }
        catch (Exception e)
        {
            //handle the exception
        }
    }

    public void InitializeTranslator() {
        // TODO: 2016/11/23
        //read the votes from the database
        t.add(new BingTranslate(0));
        t.add(new JinshanTranslate(0));
        t.add(new YoudaoTranslate(0));
    }

    public void sortTranslator() {
        Collections.sort(t);
    }
}
