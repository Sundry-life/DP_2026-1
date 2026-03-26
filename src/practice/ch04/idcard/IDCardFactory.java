package practice.ch04.idcard;

import practice.ch04.framework.Factory;
import practice.ch04.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct(String owner) { //제품 생성
        return new IDCard(owner);//idcard를 리턴 하는데 함수 타입은 product로 되어 있음 
        //부모타입은 자식 가르킬 수 있어서 가능함. 그래야 어떤 게 와도 부모로 다 받을 수 있음. 
    }

    @Override
    protected void registerProduct(Product product) { //제품 등록
        System.out.println(product + "을 등록했습니다.");
    }
}
