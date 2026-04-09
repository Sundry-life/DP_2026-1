package practice.ch10;

public class Player {
    private String name;
    private Strategy strategy; //strategy를 위임함. (strategy를 가짐.) 
    // strategy = 부모타입 => 그래서 모든 종류의 자식 객체를 가리킬 수 있다. = 교체가 쉽다 = 다형성
    private int wincount;
    private int losecount; //몇 번 이겼는지 관리: wincount, losecount, gamecount
    private int gamecount;

    // 이름과 전략을 받아서 플레이어를 만든다 
    public Player(String name, Strategy strategy) {//부모타입 => so,자식 아무거나 와도 ok
        this.name = name;
        this.strategy = strategy;
    }

    // 전략에 따라 다음 손을 결정한다 
    public Hand nextHand() { //client가 nextHand 호출시,
    // 어떤 손을 내밀지 strategy가 위임받아서 실행함.(strategy가 대신 일함.)
        return strategy.nextHand();
    }

    // 승리
    public void win() {
        strategy.study(true); //이겼을 땐, true전달 
        wincount++;
        gamecount++;
    }

    // 패배
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    // 무승부 
    public void even() {
        gamecount++;
    }

    @Override
    public String toString() { //총 게임 횟수와 이긴 횟수 등 출력. 
        return "["
            + name + ":"
            + gamecount + " games, "
            + wincount + " win, "
            + losecount + " lose"
            + "]";
    }
}
