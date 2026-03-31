package practice.ch05;

public class Main {
    public static void main(String[] args) {
        //1)까지 했을 때
        // Singleton s1 = new Singleton(); 컴파일 오류 생성자가 private하기 때문에 



        //2)까지 했을 때,
        //여기서 Singleton.get 어쩌고 에서 Singleton은 클래스명 노 객체 
        //Singleton s2 = Singleton.getInstance();
        //그치만 두 개 생성 가능 완전히 singleton은 아님 
        //Singleton s3 = Singleton.getInstance();


        //3)까지 했을 때, 진짜 singleton
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        //singleton이 로딩될때 만들어지고 리턴은 계속 똑같은 걸 리턴해주니까 두 개 만들수가 없음. 
        //같은것만 계속 받아오는 거임. 
        //즉 두 번 getInstance 해도 한 개만 객체 생성 가능해짐 

        if (s2==s3){
            System.out.println("주소 비교 결과 : 같다. 즉, 같은 객체");
        }
        System.out.println("s2값:"+s2);
        System.out.println("s3값:"+s3); //출력결과: 어떤클래스인지@주소

        //enum 사용하기 
        Singleton2 s4 = Singleton2.INSTACNE; //객체 열기 
        s4.hello();
    }
}
