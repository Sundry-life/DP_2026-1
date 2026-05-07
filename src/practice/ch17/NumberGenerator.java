package practice.ch17; 
import java.util.ArrayList;
import java.util.List;
//관찰 대상
public abstract class NumberGenerator {
    // Observer를 저장한다  
    private List<Observer> observers = new ArrayList<>(); 
    //부모 타입으로 원소 지정 -> 모든 종류의 관찰자 저장 가능. 
    //관찰대상은 구체적으로 어떤 종류의 관찰자인지 모른다.(알 필요가 없다.) (digitobserver,graphobserver몰라도 됨.)
    // 관찰자와 관찰대상은 느슨한 결합을 갖고 있다.

    // Observer를 추가한다 
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer를 제거한다 
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer에 통지한다 
    // 하나씩 꺼내와서 update() 실행해줌 (통지해줌)
    public void notifyObservers() { 
        for (Observer o: observers) { 
            o.update(this); 
            //this의 타입 = numbergenerator => 이거 넣어서 호출함 그래서 타입 잘 맞아야함.
        }
    }

    // 수를 취득한다 
    public abstract int getNumber();

    // 수를 생성한다 
    public abstract void execute();
}
