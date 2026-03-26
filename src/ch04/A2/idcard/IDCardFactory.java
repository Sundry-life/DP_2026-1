package ch04.A2.idcard;


import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;
import java.util.HashMap;
import java.util.Map;

public class IDCardFactory extends Factory {
    private int serial = 100; 
    private Map<String, Integer> db = new HashMap<>(); //Integer : 객체 정수 타입 

    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard card = (IDCard) product;
        db.put(card.getOwner(), card.getSerial()); //db에 넣기
        System.out.println(product + "을 등록했습니다.");
    }

    // 이름과 시리얼 번호 쌍을 관리하는 메서드들
    public Map<String, Integer> getOwners() {
        return db;
    }

    public int getSerial(String owner) {
        return db.get(owner);
    }

    public boolean containsOwner(String owner) {
        return db.containsKey(owner);
    }
}
