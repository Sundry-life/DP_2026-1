package hw.ch10;

public class CyclicStrategy implements Strategy {
    private int index = 0;
    @Override
    public Hand nextHand(){
        return Hand.getHand((index++)%3);
    }
    @Override
    public void study(boolean win){
    }
}
