package practice.ch10;

import java.util.Random;

public class WinningStrategy implements Strategy { 
    private Random random; 
    private boolean won = false; //이전 승부 결과 확인 
    private Hand prevHand; //이전에 낸 손 => 그래야 다음에 낼 손 결정 가능하니까. 

    public WinningStrategy(int seed) { //생성자 int하나 받음. 
        random = new Random(seed); //난수 발생기 생성 : (seed)를 항상 받아야함. 
        // seed로 어떻게 난수를 발생하게 할 지 결정 //어떤 순서로 나오게 할지 
    }

    @Override
    public Hand nextHand() {
        if (!won) { //만약 이전 단계에서 이기지 못하면
            prevHand = Hand.getHand(random.nextInt(3)); //난수로 생성
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win; //이겼으면 won = True 로 변경
    }
}
