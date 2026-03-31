package practice.ch05;

public class Singleton {
    //3) 객체를 미리 만들어둠. 
    //반드시 static -> class에 속한다.
    private static Singleton singleton = new Singleton();
    
    //1) 생성자를 private로 함
    private Singleton(){
        System.out.println("singleton 객체 생성 완료");
    }
    //2) singleton을 얻어갈 수 있는 메소드를 정의 
    //stactic을 통해서 객체를 생성하지 않아도 ok <-? 
    public static Singleton getInstance(){
        //2) return new Singleton();
       
       //3) 클래스 속성으로 리턴
        return singleton; 
    }



}
