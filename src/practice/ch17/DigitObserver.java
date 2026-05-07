package practice.ch17;
//구체적인 관찰자 1번
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) { //통지받으면 관찰자가 하는 일.
        System.out.println("DigitObserver:" + generator.getNumber()); //그냥 출력함. 

        // cpu를 내놓고 대기
        try {
            Thread.sleep(1000); // 100*1/1000 = 즉 0.1초 대기  
            // 1000 * 1/1000 라서 1초 대기 -> 하나 출력하고 1초 대기 (변경시) 하나 출력하고 1초 대기 이런식으로 가는거 
        } 
        catch (InterruptedException e) { 
            //항상 try catch로 묶어야함. // 슬립 못할때의 오류  // 슬립 못할 경우, 딱히 처리할 내용 없으니 빈칸
        }
    }
}
