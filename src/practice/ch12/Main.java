package practice.ch12;

public class Main {
    public static void main(String[] args) {
        Display d1 = new StringDisplay("Hello world");
        d1.show();
        Display d2 = new SideBorder(d1, '#');
        d2.show();
        Display d3 = new SideBorder(d2,'*');
        d3.show();
        Display d4  = new FullBorder(d3);
        d4.show();
        Display d5 = new SideBorder(d4,'/');
        d5.show();
    }
}
