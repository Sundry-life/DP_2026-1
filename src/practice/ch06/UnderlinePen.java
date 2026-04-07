package practice.ch06; 

import practice.ch06.framework.Product;

public class UnderlinePen implements Product {
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar; 
    }

    @Override
    public void use(String s) {
        int ulen = s.length();
        System.out.println(s);
        for (int i = 0; i < ulen; i++) {
            System.out.print(ulchar); //string s 길이 만큼 char 출력
        }
        System.out.println();
    }

    @Override
    public Product createCopy() { //복제 메소드 
        Product p = null;
        try {
            p = (Product)clone(); //clone호출 
        } catch (CloneNotSupportedException e) { 
            e.printStackTrace();
        }
        return p; //clone 리턴
    }
}
