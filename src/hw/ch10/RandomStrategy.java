package hw.ch10;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random random;

    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public void study(boolean win) { //study는 할 거 없어서 비워둠
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }
}
