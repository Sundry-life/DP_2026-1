package practice.ch10;

public class Main {
    public static void main(String[] args) {
    //     //손을 2개 생성.
    //     //enum클래스에 생성되어 있어서 얻는다고 보는게 맞음
    //     //손 2개 얻기 
    //     Hand h1 = Hand.ROCK; //주먹을 얻는거
    //     Hand h2 = Hand.SCISSORS; //가위 얻기 

    //     // 손끼리 승부
    //     if(h1.isStrongerThan(h2))
    //         System.out.println("h1이 이겼습니다.");
    //     else if(h1.isWeakerThan(h2))
    //         System.out.println("h2가 이겼습니다.");
    //     else
    //         System.out.println("비겼습니다.");


    //Player 2명 생성
    Player player1 = new Player("A", new WinningStrategy(314));
    Player player2 = new Player("B", new WinningStrategy(13)); //seed는 다르게 = 그래야 다른 순서로 나오니까 

    //대결 
    for(int i = 0; i < 10; i ++){
        //플레이어 2명에게 각각 손을 얻고
        Hand h1  = player1.nextHand();
        Hand h2 = player2.nextHand();
        //손을 대결 시킴 
        if(h1.isStrongerThan(h2)){
            System.out.println("Winner"+player1);
            player1.win();
            player2.lose();
        }
        else if(h1.isWeakerThan(h2)){
            System.out.println("Winner"+player2);
            player1.lose();
            player2.win();
        }
        else{
            System.out.println("비겼습니다.");
            player1.even();
            player2.even();
        }
    }

    }

}
