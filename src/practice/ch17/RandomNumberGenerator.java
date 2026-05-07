package practice.ch17;
import java.util.Random;
//구체적인 관찰 대상
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   		// 현재 수 (난수 생성한거 값 저장(메모))

    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다 
    @Override
    public void execute() { 
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50); // 0~49 사이의 난수 생성하기
            notifyObservers(); //상태(number)변경되어서 통지함. 
            //notifyObservers는 부모에서 구현된거 
        }
    }
}
