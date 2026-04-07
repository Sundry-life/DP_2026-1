package practice.ch06.framework;
import java.util.HashMap;
import java.util.Map;
public class Manager {
    private Map<String,Product> showcase = new HashMap<>(); //해쉬맵 key,value쌍으로 저장
    //key = string, value = product  : <String, Product>
    //원래 new HashMap<String, Product>(); 인데 차피 똑같으니 생략 ok 
    //Product = interface 즉, 상속받아서 product 종류로 구현된 모든 거 가져와도 ok 여기선 messagebox, underlinepen
    //즉 부모타입product로 value지정해서 자식인 messagebox, underlinepen 모두 가져와도 ok 

    public void register(String name, Product prototype) { // (이름, product)들어오면
        showcase.put(name, prototype);//해쉬맵에 넣기 
    }

    public Product create(String prototypeName) {
        Product p = showcase.get(prototypeName); //이름(key)받으면 그거에 맞는 value꺼내오기
        return p.createCopy(); //근데 그냥 주는게 아니라 복제해서 반환함. //<- 중요 
    }
}
