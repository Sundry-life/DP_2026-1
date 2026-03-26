package practice.ch04;
import practice.ch04.idcard.IDCardFactory;
import practice.ch04.framework.Product;
public class Main {
    public static void main(String[] args) {

        //id card 생성 생성자가 private라 생성자 오류남
        // IDCard c1  = new IDCard("sun");
        // c1.use();

         //공장으로 id card 생성
         IDCardFactory factory = new IDCardFactory();
         Product c2 = factory.create("sun");
         c2.use();
    }
}
