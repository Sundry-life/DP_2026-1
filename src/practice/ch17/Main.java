package practice.ch17;

public class Main {
    public static void main(String[] args) {
        //관찰 대상 생성
        RandomNumberGenerator subject = new RandomNumberGenerator();
        // 관찰자 생성
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        // 관찰 대상에다가 관찰자 등록하기
        subject.addObserver(observer1); //등록되는 순서 => 업데이트 되는 순서 : 왜냐 리스트에서 순차적으로 꺼내오니까 
        subject.addObserver(observer2);
        //관찰 대상을 실행하기 
        subject.execute();
    }   
}
