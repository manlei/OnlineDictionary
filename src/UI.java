import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Eric on 2016/11/23.
 */
public class UI extends JFrame{
    protected JTextField searchText;
    protected JButton searchButton;
    protected JTextArea Area1;
    protected JTextArea Area2;
    protected JTextArea Area3;
    // TODO: 2016/11/23
    //the vote button to be added
    protected JButton vote1;
    protected JButton vote2;
    protected JButton vote3;
    protected ArrayList<Translator> t=new ArrayList<>(3);

    public UI() {

        setTitle("Welcome to the dictionary");
        setSize(800,600);
        String path="icon.png";
        ImageIcon icon=new ImageIcon(path);
        this.setIconImage(icon.getImage());

        //set background
        path="background.jpg";
        ImageIcon background=new ImageIcon(path);
        JLabel label=new JLabel(background);
        label.setBounds(0,0,this.getWidth(),this.getHeight());
        JPanel imageJPanel=(JPanel)this.getContentPane();
        imageJPanel.setOpaque(false);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        Font xFont=new Font("Segoe Print",0,20);
        Font yFont=new Font("consolas",0,20);
        Font zFont=new Font("serif",1,20);

        //set searchText
        searchText = new JTextField(1);
        searchText.setFont(xFont);
        searchText.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.GRAY));

        //set searchButton
        path="search.png";
        ImageIcon searchIcon=new ImageIcon(path);
        searchButton = new JButton();
        searchButton.setIcon(searchIcon);
        searchButton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));

        //set explanationArea
        Area1=new JTextArea();
        Area1.setEditable(false);
        Area1.setFont(zFont);
        Area1.setOpaque(false);
        Area2=new JTextArea();
        Area2.setEditable(false);
        Area2.setFont(zFont);
        Area2.setOpaque(false);
        Area3=new JTextArea();
        Area3.setEditable(false);
        Area3.setFont(zFont);
        Area3.setOpaque(false);

        add(searchText);
        add(searchButton);
        add(Area1);
        add(Area2);
        add(Area3);

        setLayout(null);

        searchText.setBounds(50,20,600,50);
        searchButton.setBounds(700,20,50,50);
        Area1.setBounds(100,200,600,80);
        Area2.setBounds(100,300,600,80);
        Area3.setBounds(100,400,600,80);

        setVisible(true);
        setResizable(false);
    }


    public void setArea1(String translation) {
        Area1.setText(t.get(0).name+":\t"+translation);
    }

    public void setArea2(String translation) {
        Area2.setText(t.get(1).name+":\t"+translation);
    }

    public void setArea3(String translation) {
        Area3.setText(t.get(2).name+":\t"+translation);
    }

    public void setMessage(String message) {
        Area1.setText(message);
    }
}
