package practice.ch05.ex;

public class Main extends Thread {
    public static void main(String[] args) {
        //스레드 객체 생성
        Main t1 = new Main("Thread - A");
        Main t2 = new Main("Thread - B");

        //스래드 실행 지시
        t1.start(); //정의한 run메소드 자동 실행. 
        t2.start();

    }
    //thread가 해야할 일 정의
    @Override 
    public void run(){
        Singleton s = Singleton.getInstance();
        System.out.println(getName()+ ":"+s); //이름 : 주소 형태 출력
    }
    public Main(String name){
        super(name);
    }

    //생성자 함수 안의 출력문 두번 = 즉, 두개 생성됨. 
    // 시간 차이 때문에 문제 발생

}
