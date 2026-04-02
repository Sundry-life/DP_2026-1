package practice.ch06;

import practice.ch06.framework.Product;

public class MessageBox implements Product {
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;//위 아래 캐릭터 출력해야할 길이: 데코length
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar); //출력
        }
        System.out.println(); //줄바꿈
        System.out.println(decochar + s + decochar); // 양쪽에 찍기 + 캐릭터 :데코char
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar); //출력
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone(); //clone메소드 -> 복사 쉽게 ok //return은 product타입이니까 형변환해서  
            //안그럼 오브젝트 타입 -> 부모로 줌 부모를 자식에다 넣을 수 없으니까. 형변환 필수 <- 무슨소리지

        } catch (CloneNotSupportedException e) {//clone not supported exception  
            e.printStackTrace(); //오류났을 때 대비  : try - catch문으로 
        }
        return p; 
    }
}
