package hw.ch17;

public class RangeObserver implements Observer{
    @Override
    public void update(NumberGenerator generator){
        System.out.print("RangeObserver: ");
        int num = generator.getNumber();
        if(0< num && num <10){
            System.out.println("[Low] "+num);
        }
        else if(num<20){
            System.out.println("[Mid] "+num);
        }
        else{
            System.out.println("[High] "+num);
        }
    }
    
}
