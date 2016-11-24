package chopin;

import java.util.*;

public class Chopin {

    public static void main(String[] args) {
        Window window = new Window(500, 200, 420, 240, "CHOPIN");
        Vector<Integer> hight = new Vector<Integer>();
        Vector<Integer> lenght = new Vector<Integer>();
        hight.add (0);
        hight.add (5);
        hight.add (15);
        hight.add (20);
        hight.add (30);
        hight.add (50);
        hight.add (75);
        hight.add (90);
        hight.add (100);
        
        lenght.add (0);
        lenght.add (5);
        lenght.add (15);
        lenght.add (40);
        lenght.add (70);
        lenght.add (100);
        
        Vector<Note> vec = new Vector ();
        vec.add (new Note(0,0));
        
        Composer comp = new Composer(hight, lenght);
        for(int i = 1; i <= 60; i ++) {
            Note temp = comp.getNote();
            window.fillIn(comp.getString(temp) - 1 , i , comp.getTone(temp));
            window.fillInNut(i, new Integer(2400 / temp.getLenght()).toString());
            System.out.print(i + " ");
        }
    }
    
}
