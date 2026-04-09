package practice.ch10;
public enum Hand { //enum class : 상수를 정의하는 클래스
    // 가위 바위 보를 나타내는 세 개의 enum 상수
    //각 상수는 Hand 객체(인스턴스)를 생성해서 가짐.
    ROCK("바위", 0), //인자 있음 = 생성자 호출 
    SCISSORS("가위", 1), 
    PAPER("보", 2);

    // enum이 가진 필드 
    private String name; // 가위 바위 보 손의 이름
    private int handvalue; // 가위 바위 보 손의 값 

    // 손의 값으로 상수를 얻기 위한 배열
    // hand 인스턴스 배열  / 인덱스 rock = 0 scissors = 1 papaer = 2 
    // static = hand 클래스에 속함
    private static Hand[] hands = {
        ROCK, SCISSORS, PAPER
    };

    // 생성자 
    private Hand(String name, int handvalue) {
        this.name = name;
        this.handvalue = handvalue;
    }

    // 손의 값으로 enum 상수를 가져온다 
    // int값 받아서 배열에서 꺼내기 
    public static Hand getHand(int handvalue) {
        return hands[handvalue];
    }

    // this가 h보다 강할 때 true
    //인자가 Hand  isStrongerThan은 hand class
    //그래서 this = hand class 의 인스턴스 
    // h = 입력받은 hand 인스턴스 
    public boolean isStrongerThan(Hand h) { 
        return fight(h) == 1; // fight(h)가 1이랑 같냐 아니냐 bool값 return
    }

    // this가 h보다 약할 때 true
    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    // 무승부는 0, this가 이기면 1, h가 이기면 -1
    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == h.handvalue) {
            return 1;
        } else {
            return -1;
        }
    }

    // 가위 바위 보의 문자열 표현
    @Override
    public String toString() {
        return name;
    }
}

