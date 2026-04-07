package hw.ch04;
import hw.ch04.framework.Product; 
import hw.ch04.idcard.IDCardFactory;
import hw.ch04.license.LicenseCardFactory;

import hw.ch04.framework.Factory; // 이건 왜 필요함 어차피 상속한거 아닌가 
//factory로 받아서 부모로 받아서 뭐가오든 상관없게 하려고 한건가 두개가 되어서 이전거랑 다르게 필요한듯.
public class Main {
    public static void main(String[] args) {
        System.out.println("20240856 김선아");
        System.out.println("[3-1] : IDCard 정보 확장 ");
        Factory factory1 = new IDCardFactory("2026-03-20"); 
        Product card1 = factory1.create("Kim Youngjin");
        Product card2  = factory1.create("Son Heungimin");
        card1.use();
        card2.use();

        System.out.println("[3-2] : 새로운 카드 타입");
        Factory factory2 = new LicenseCardFactory("2026-03-20");
        Product license1 = factory2.create("Park Jisung");
        Product license2 = factory2.create("Lee Min-jae");
        license1.use();
        license2.use();
    }
}
