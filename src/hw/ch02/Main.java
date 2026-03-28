package hw.ch02;

public class Main {
    public static void main(String[] args) {
        System.out.println("20240856 김선아");
        Charger outlet = new KoreanOutletAdapter();
        Smartphone charger = new Smartphone(outlet);
        charger.charge();
    }
    
    
}
