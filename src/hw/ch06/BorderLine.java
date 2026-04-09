package hw.ch06;
import hw.ch06.framework.Product; 
public class BorderLine implements Product{
  private char borderChar; 

    public BorderLine(char borderChar) {
        this.borderChar = borderChar; 
    }

    @Override
    public void use(String s) {
        int blen = s.length();
        for (int i = 0; i < blen; i++) {
            System.out.print(borderChar);
        }
        System.out.println('\n'+s);
        for (int i = 0; i < blen; i++) {
            System.out.print(borderChar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
