package practice.ch20;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory { //공장은 하나만 있어야 해서 싱글턴 패턴 적용
    // 이미 만든 BigChar 인스턴스를 관리 
    private Map<String,BigChar> pool = new HashMap<>();//key = string, value = Bigchar
    // Singleton 패턴 
    private static BigCharFactory singleton = new BigCharFactory();

    // 생성자 
    private BigCharFactory() {
    }

    // 유일한 인스턴스를 얻는다
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) {
        //이미 만들어진 BigChar이 있는지 검색함
        BigChar bc = pool.get(String.valueOf(charname));
        if (bc == null) { //없으면 
            // 여기서 BigChar 인스턴스를 생성 
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc); 
            //char을 string으로 바꿔줌 valueOf()
            //key 가 string타입이어서 char가 아닌 string으로 넣기 위해 써줌
        }
        return bc; //있으면 return
    }
}
