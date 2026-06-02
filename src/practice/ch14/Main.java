package practice.ch14;

public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob",100); //100 이하 숫자 처리 
        Support charlie = new SpecialSupport("Charlie",429);
        Support diana = new OddSupport("Diana");

        // 사슬 형성 
        alice.setNext(bob).setNext(charlie).setNext(diana);

        // 다양한 트러블 발생
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
