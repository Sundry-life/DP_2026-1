package practice.ch19;

public class Main {
    public static void main(String[] args) {
        //GUI 생성
        SafeFrame frame = new SafeFrame("금고 경비 시스템");
        //시계역할 구현
        //1초마다 현재시간을 얻어서 sateFrame의 setClock에게 전달
        // Thread.sleep(1000) = 1초마다 
        // 뭐 하고 1초 기다리고 뭐 하고 1초하고 -> 이런식으로 하면 시계처럼 동작 가능
        while(true){ //24시간 무한 반복  //for문(즉, 0~24)를 무한 반복하는거 
            for(int hour =0; hour < 24; hour++){ //0~24시간 까지 for문 돎
                frame.setClock(hour); //시간 알려주고
                try{
                    Thread.sleep(1000); //1초 대기 
                }
                catch(InterruptedException e){
                }
            }
        }
    }
}
