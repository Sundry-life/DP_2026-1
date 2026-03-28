package hw.ch03;

public class Main {
    public static void main(String[] args) {
        System.out.println("20240856 김선아");
        // 'H'를 가진 CharDisplay 인스턴스를 하나 만든다 
        AbstractDisplay d1 = new CharDisplay('H');

        // "Hello, world."를 가진 StringDisplay 인스턴스를 하나 만든다 
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        d1.display();
        d2.display();
        System.out.println("\n");
        //확장한 것 시현 
        AbstractDisplay d3 = new CharDisplay('X',3);
        AbstractDisplay d4 = new StringDisplay("Test",7);
        d3.display();
        d4.display();
        AbstractDisplay num = new NumberDisplay(42,4);
        num.display();
    }
}
