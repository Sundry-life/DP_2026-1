package hw.ch10;

public class Main {
    public static void main(String[] args) {
        System.out.println("20240856 김선아");
        System.out.println("===== RandomStrategy =====");
        Player player1 = new Player("Taro", new RandomStrategy(0));

        System.out.println("\n===== CyclicStrategy =====");
        Player player2 = new Player("Bob", new CyclicStrategy());

        System.out.println("Cyclic Strategy의 손가락 순환 : ");
        Strategy cyclic = new CyclicStrategy();
        for(int i = 0; i< 9; i ++){
            Hand hand = cyclic.nextHand();
            System.out.println((i+1)+" 번째: "+hand);
            cyclic.study(false);
        }

        System.out.println("\n게임 진행 코드");
        for(int i = 0 ; i < 10; i++){
            Hand h1 = player1.nextHand();
            Hand h2 = player2.nextHand();
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
        System.out.println("\n승부 결과");
        System.out.println(player1);
        System.out.println(player2);

    }
    
}
