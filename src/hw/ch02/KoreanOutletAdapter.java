package hw.ch02;

public class KoreanOutletAdapter implements Charger{
    private KoreanOutlet outlet;
    public KoreanOutletAdapter(){
        this.outlet = new KoreanOutlet();
    } 
    @Override
    public int charge(){
       return outlet.provide();
    }

    
}
