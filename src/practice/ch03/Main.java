package practice.ch03; 

public class Main {
    public static void main(String[] args) {
    
        CharDisplay d1 = new CharDisplay('H'); //cf. 작은 따옴표 = char 큰 따옴표 = String 
        d1.display(); 
       StringDisplay d2 = new StringDisplay("Hello World");
       d2.display();
    }
}
