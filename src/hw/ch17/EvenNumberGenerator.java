package hw.ch17;

public class EvenNumberGenerator extends NumberGenerator{
    private int start; 
    private int number; 
    private int end; 
    public EvenNumberGenerator(int start, int end){
        this.start = start; 
        this.end = end; 
    }

    @Override
    public void execute(){
        number = start; 
        while(number<end){
            notifyObservers();
            number += 2; 
        }
    }
    @Override
    public int getNumber(){
        return number; 
    }
}
