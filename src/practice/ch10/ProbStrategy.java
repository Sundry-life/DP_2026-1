package practice.ch10;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0; //이전에 냈던 손의 값//초기값 주먹
    private int currentHandValue = 0; //바로 직전에 낸 손의 값 (그니까 현재 손)//초기값 주먹 /
    private int[][] history = {
        { 1, 1, 1, },
        { 1, 1, 1, },
        { 1, 1, 1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed); 
    }

    @Override
    public Hand nextHand() { //핵심파트
        int bet = random.nextInt(getSum(currentHandValue));  //3+5+7한거나 마찬가지 전체 이긴횟수 합 //현재 손
        int handvalue = 0;//이번에 낼 손 (다음 손의 값) nextHand
        if (bet < history[currentHandValue][0]) { //0--3 영역 
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) { //0--3--8 여기 영역
            handvalue = 1;
        } else { //?암튼 if문은 난수가 어느 범위에 위치해있는지 판단해서 다음 손 지정
            handvalue = 2;
        }
        prevHandValue = currentHandValue; //갱신 (다음 손 = 현재손으로, 현재손 = 이전이전 손)
        currentHandValue = handvalue;
        return Hand.getHand(handvalue); //손 내밀기 
    }

    private int getSum(int handvalue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) { //그 행의 값들 다 더하기 
            sum += history[handvalue][i]; //행 번호 고정, 열 번호 변화
        }
        return sum;
    }

    @Override //승부에따라 테이블 배열 변화
    public void study(boolean win) {
        if (win) {  
            history[prevHandValue][currentHandValue]++;
        } else { //졌으면 나머지 칸에다가 +1? 뭐집..
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
