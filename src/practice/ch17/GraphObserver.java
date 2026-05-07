package practice.ch17;
//구체적인 관찰자 2번 
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) { //통지받을 때 호출되는 메소드
        System.out.print("GraphObserver:"); // 자기 이름 출력

        int count = generator.getNumber(); //관찰 대상의 현재 상태(number)를 count에 저장

        for (int i = 0; i < count; i++) {
            System.out.print("*"); //별표를 상태(number)만큼 출력
        }
        System.out.println("");//줄바꿈


        //대기 
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
