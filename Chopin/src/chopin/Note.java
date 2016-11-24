package chopin;

public class Note {
    public Note () {
        
    }
    
    public Note (int _hight, int _lenght) {
        lenght = _lenght;
        hight = _hight;
    }
    
    public int getLenght() {
        return lenght;
    }
    
    public int getHight () {
        return hight;
    }
    
    private int lenght, hight;
    
}
