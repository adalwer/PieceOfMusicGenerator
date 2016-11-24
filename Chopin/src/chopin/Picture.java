package chopin;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Picture extends JPanel{
    BufferedImage img;
    
    public JLabel l;
    
    public Picture () {
        super ();
        setLayout (null);
    }
    
    public Picture (int x, int y, int width, int height, String url) {
        setLayout (null);
        init (x, y, width, height ,url);
    }
    
    public void init (int x, int y, int width, int height, String url) {
        
        
        setBounds (x, y, width, height);
        setVisible (true);
        
        readImage (url);
    }
    
    public void paintComponent (Graphics g) {
        g.drawImage(img, 0, 0,getWidth(), getHeight(), null);
    }

    private void readImage (String url) {
        try {
            img = ImageIO.read(new File(url));
        } catch (IOException e) {
           System.out.print("this URL: " + url + " is not correct!\n");
        }
    }
    
    
}
