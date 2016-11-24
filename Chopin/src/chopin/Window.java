package chopin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame {
    
    private Picture [][] tab;
    private Picture [] nut;
    public Window (int x, int y, int width, int height, String title) {
        setLayout(null);
        createUI ();
        createTab ();
        setSize (width, height);
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
        setVisible (true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocation(new Point (x, y));
        setTitle(title);
        
        
    }
    
    private void createUI () {
        
    }
    
    private void createTab () {
        tab = new Picture [6][75];
        for(int i = 0; i < 6; i ++) {
            for(int j = 0; j < 75; j ++) {
                System.out.print (i + " " + j + "\n");
                tab [i][j] = new Picture(j * 20, i * 10 + 50 , 20, 10, "/home/adam/NetBeansProjects/Chopin/line.gif");
                add(tab[i][j]);
            }
        }
        nut = new Picture [75];
        for(int i = 0; i < 75; i ++ ) {
            nut[i] = new Picture (i * 20, 110, 20, 40, "/home/adam/NetBeansProjects/Chopin/note11.gif" );
            add (nut [i]);
        }
    }
    
    public void fillIn (int str, int pos, int tune) {
        JLabel l = new JLabel ("" + "" + (char)(tune + 48));
        l.setVisible(true);
        l.setBounds (0,0,20,10);
        tab[str][pos].add(l);
    }
    
    public void fillInNut (int pos, String r) {
        nut [pos].init (pos * 20, 110, 20, 40, "/home/adam/NetBeansProjects/Chopin/note1" + r + ".gif");
    }
    
}
