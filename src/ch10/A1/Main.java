package ch10.A1;

public class Main {
    public static void main(String[] args) { //args를 받아서 메인 실행됨
        //args를 사용함 args 입력 => 원칙적으로 java (class)이런식으로 터미널에서 실행해야함.
            // 항상 그냥 런타임 버튼 딸깍했던거 사실은 터미널로
            // java Main 111 222 333이런식으로 데이터 줄 수 있음 이 인자는 Main에 전달되는 인자 
            // args[]={"111","222","333"}
        if (args.length != 2) { //명령행 인자를 2개 받아왔는지 검사하고
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15"); 
            System.exit(0); //종료
        }
        int seed1 = Integer.parseInt(args[0]); //문자열이라서 숫자로 변경 
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("Taro", new ProbStrategy(seed1));
        Player player2 = new Player("Hana", new RandomStrategy(seed2));
        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
