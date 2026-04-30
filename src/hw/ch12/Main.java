package hw.ch12;

public class Main {
    public static void main(String[] args) {
        System.out.println("20240856 김선아");
        System.out.println("2-1 MultiStringDisplay show()");
        Display md = new MultiStringDisplay();
        ((MultiStringDisplay)md).add("Hello java!");
        ((MultiStringDisplay)md).add("Decorator Patter");
        ((MultiStringDisplay)md).add("is powerful");
        md.show();

        System.out.println("2-2 NumberedBorder 단독 적용");
        Display d1 = new NumberedBorder(md);
        d1.show();

        System.out.println("2-3 FullBorder + NumberedBorder 적용");
        Display d2 = new FullBorder(d1);
        d2.show();

        System.out.println("2-4 SideBorder + NumberedBorder + FullBorder 적용");
        Display d3 = new SideBorder(new NumberedBorder(new FullBorder(md)),'*');
        d3.show();
    }   
}
