package hw.ch20;
public class Main {
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String RESET = "\u001B[0m";
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }
        String[] colors = new String[7] ;
        colors[0] = RED;
        colors[1] = BLUE;
        colors[2] = GREEN;
        colors[3]= MAGENTA;
        colors[4] = CYAN;
        colors[5] = YELLOW;
        colors[6] =BLUE;
        BigString bs = new BigString(args[0]);
        bs.print(colors);
    }
}
