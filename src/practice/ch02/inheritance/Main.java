package practice.ch02.inheritance;

public class Main {
    public static void main(String[] args) {
        Banner banner = new Banner("hello world");
        banner.showWithParen();
        banner.showWithAster();

        //어댑터 이용
        System.out.println("Adapter이용");
        Print print = new PrintBannerAdapter("hello, world");
        print.printWeak();
        print.printStrong();
    }
}
