package practice.ch05.ex;
//다른 방법의 싱글톤 패턴
public class Singleton {
    private static Singleton singleton = null; //null이 넣어짐 = 아직 안 만들어짐. 

    private Singleton() { //아무나 생성 못하게 so private인건 똑같.
        System.out.println("인스턴스가 생성되었습니다.");
        slowdown(); //인스턴스 생성될 때, 시간을 좀 지연시켜보는 것. 
    }

    public static Singleton getInstance() { //getInstance 호출될때, 
        if (singleton == null) { // 널이면 만들겠다. 
            singleton = new Singleton(); 
            //만들어지면, 이제 널이 아니게 되기에, 그 후 호출되는 getInstace는 if문에 해당 안됨. 
        }
        return singleton;
    }

    private void slowdown() { 
        try {
            Thread.sleep(1000); //cpu를 내놓고 쉼 1000=1초
        } catch (InterruptedException e) {
        }
    }
}
