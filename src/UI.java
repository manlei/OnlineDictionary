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
    // TODO: 2016/11/26
    // the checkbox to be added
    protected JCheckBox select1;
    protected JCheckBox select2;
    protected JCheckBox select3;

    protected ArrayList<WORD> answer;

    public UI() {

        setTitle("Welcome to the dictionary");
        setSize(800,800);
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

        //set explanationArea and its JScrollPane
        Area1=new JTextArea();
        Area1.setEditable(false);
        Area1.setFont(zFont);
        JScrollPane Area1JScrollPane=new JScrollPane(Area1);
        Area1JScrollPane.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        Area1.setOpaque(false);
        Area1JScrollPane.setOpaque(false);
        Area1JScrollPane.getViewport().setOpaque(false);

        Area2=new JTextArea();
        Area2.setEditable(false);
        Area2.setFont(zFont);
        JScrollPane Area2JScrollPane=new JScrollPane(Area2);
        Area2JScrollPane.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        Area2.setOpaque(false);
        Area2JScrollPane.setOpaque(false);
        Area2JScrollPane.getViewport().setOpaque(false);

        Area3=new JTextArea();
        Area3.setEditable(false);
        Area3.setFont(zFont);
        JScrollPane Area3JScrollPane=new JScrollPane(Area3);
        Area3JScrollPane.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        Area3.setOpaque(false);
        Area3JScrollPane.setOpaque(false);
        Area3JScrollPane.getViewport().setOpaque(false);

        add(searchText);
        add(searchButton);
        add(Area1JScrollPane);
        add(Area2JScrollPane);
        add(Area3JScrollPane);

        setLayout(null);

        searchText.setBounds(50,20,600,50);
        searchButton.setBounds(700,20,50,50);
        Area1JScrollPane.setBounds(50,120,600,200);
        Area2JScrollPane.setBounds(50,340,600,200);
        Area3JScrollPane.setBounds(50,560,600,200);

        setVisible(true);
        setResizable(false);
    }


    public void setArea1(WORD wd) {
        Area1.setText(wd.translator+":\n"+wd.word+" "+wd.usPhonetic+" "+wd.ukPhonetic+"\n");
        for(int i=0;i<wd.explains.size();++i)
            Area1.append(wd.explains.get(i)+"\n");
    }

    public void setArea2(WORD wd) {
        Area2.setText(wd.translator+":\n"+wd.word+" "+wd.usPhonetic+" "+wd.ukPhonetic+"\n");
        for(int i=0;i<wd.explains.size();++i)
            Area2.append(wd.explains.get(i)+"\n");
    }

    public void setArea3(WORD wd) {
        Area3.setText(wd.translator+":\n"+wd.word+" "+wd.usPhonetic+" "+wd.ukPhonetic+"\n");
        for(int i=0;i<wd.explains.size();++i)
            Area3.append(wd.explains.get(i)+"\n");
    }

    public void setMessage(String message) {
        Area1.setText(message);
    }
}
