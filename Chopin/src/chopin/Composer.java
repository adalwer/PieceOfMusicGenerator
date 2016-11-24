package chopin;

import java.util.*;

public class Composer {
    
//*********************private members******************************************
//******************************************************************************
    private Random rand;
    
    Vector<Integer> lenghtProbability;
    Vector<Integer> hightProbability;
    public tone [] T;
    private int last;
    private int originalLenght;
    private int previous;

    private class tone {
        public int string, ton;
        public tone (int str, int _ton) {
            ton = _ton;
            string = str;
        }
        public tone () {
            
        }
    }
    
//*********************public members*******************************************
//******************************************************************************
    
 
//*********************constructors*********************************************
//******************************************************************************  
    
    public Composer () {
        rand = new Random();
    }

    public Composer (Vector<Integer> _hights, Vector<Integer> _lenghts) {
        rand = new Random();
        composerSettings (_hights, _lenghts);
    }

//*********************public  methods******************************************
//******************************************************************************
    
    public void composerSettings (Vector<Integer> _hights, Vector<Integer> _lenghts) {
        T = new tone [20];
        last = 2400;
        originalLenght = 2400;
        lenghtProbability = new Vector<Integer> ();
        hightProbability = new Vector<Integer> ();
        lenghtProbability.setSize(_lenghts.size());
        hightProbability.setSize(_hights.size());
        for (int i = 1; i < _hights.size(); i++) {
            hightProbability.setElementAt(_hights.elementAt(i), i);
        }
        for (int i = 1; i < _lenghts.size(); i++) {
            lenghtProbability.setElementAt(_lenghts.elementAt(i), i);
        }
        lenghtProbability.setElementAt(0, 0);
        hightProbability.setElementAt(0, 0);
        T [0] = new tone ();
        T [1] = new tone (6, 1);
        T [2] = new tone (6, 3);
        T [3] = new tone (6, 5);
        T [4] = new tone (5, 2);
        T [5] = new tone (5, 3);
        T [6] = new tone (5, 5);
        T [7] = new tone (4, 2);
        T [8] = new tone (4, 3);
        T [9] = new tone (4, 5);
        T [10] = new tone (3,2);
        T [11] = new tone (3,4);
        T [12] = new tone (3,5);
        T [13] = new tone (2,3);
        T [14] = new tone (2,5);
        T [15] = new tone (2,6);
        T [16] = new tone (1,3);
        T [17] = new tone (1,5);
        T [18] = new tone (1,7);
    }
    
    public Note getNote () {
        return new Note(getRandomHight(), getRandomLenght());
    }

    public void writeNotes (Vector<Note> notes) {
        char [][] toWrite = new char [12][notes.size() * 2];
        for(int i = 1; i <= 6; i ++) {
            for(int j = 0; j < notes.size() * 2; j ++) {
                toWrite [i][j] = '-';
            }
        }
        for (int i = 0; i < notes.size(); i ++) {
            toWrite [T[notes.elementAt(i).getHight()].string][i * 2] = (char)(T[notes.elementAt(i).getHight()].ton + 48);
        }
        for(int i = 6; i > 0 ; i --) {
            for(int j = 0; j < notes.size() * 2; j ++) {
                System.out.print(toWrite[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("  ");
        for(int i = 1; i < notes.size(); i ++)
        {
            System.out.print((originalLenght / notes.elementAt(i).getLenght()) + " ");
        }
    }
    
    public int getString (Note a) {
        return T[a.getHight()].string;
    }
    
    public int getTone (Note a) {
        return T[a.getHight()].ton;
    }
//*********************private methods******************************************
//******************************************************************************
    
    private int getRandomLenght () {
        int retLenght = originalLenght;
        while (true) {
            retLenght = originalLenght;
            int probability = (rand.nextInt(100)) + 1;
            for (int i = 1; i < lenghtProbability.size(); i++) {
                if (probability <= lenghtProbability.elementAt(i) && probability > lenghtProbability.elementAt(i - 1)) {
                    break;
                }
                retLenght /= 2;
            }
            if (retLenght <= last) {
                break;
            }
        }
        last -= retLenght;
        if (last == 0) {
            last = originalLenght;
        }
        System.out.print("    " + retLenght + "\n");
        return retLenght;
    }

    private int getRandomHight () {
        int ret = previous;
        int direct;
        int now = 0;
        while (true) {
            now = 0;
            ret = previous;
            direct = rand.nextInt() % 2;
            if(direct == 0)
                direct = -1;
            else
                direct = 1;
            int probability = (rand.nextInt(100)) + 1;
            for(int i = 1; i < hightProbability.size(); i ++) {   
                if(probability <= hightProbability.elementAt(i) && probability > hightProbability.elementAt(i-1)) {
                    now = i - 1;
                    break;
                }
            }
            if(ret + (now *direct) > 0 && ret + (now * direct) <= 18) {
                break;
            }
        }
        previous = ret + (now * direct);
        return ret + (now * direct);
    }
    
}
