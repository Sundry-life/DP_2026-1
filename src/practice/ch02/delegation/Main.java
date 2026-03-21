package practice.ch02.delegation;

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBannerAdapter("Hello");
        p.printWeak();
        p.printStrong();
    }
}
