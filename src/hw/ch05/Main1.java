package hw.ch05;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("20240856 김선아");
        System.out.println("\n========== 방식 1: Static Initializer =========="); 
        LoggerStaticInit logger1a = LoggerStaticInit.getInstance(); 
        LoggerStaticInit logger1b = LoggerStaticInit.getInstance(); 
 
        logger1a.log("Static Message 1"); 
        logger1b.log("Static Message 2"); 
 
        if (logger1a == logger1b) { 
            System.out.println("동일한 인스턴스"); 
        }
        else { 
            System.out.println("다른 인스턴스"); 
        } 
        System.out.println("\n========== 로그 출력 1 ==========");      
        System.out.println("[LoggerStaticInit 로그]"); 
        System.out.println(logger1a.getLog());  //같은 객체 -> so, 같은 loggerbuffer에 접근 그래서 
        // a 에 있는 log 만 가져왔는데도 불구하고 loggerbuffer에는 b가 써둔 메세지 2까지 찍혀있는 것을 볼 수 잇다. 
    }
}
