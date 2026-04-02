package hw.ch05;

public class LoggerSynchronizedLazy {
    private static LoggerSynchronizedLazy instance = null; 
    private StringBuilder logBuffer; 
    private LoggerSynchronizedLazy(){
        System.out.println("SynchronizedLazy 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder(); 
        slowdown();
    }
    public static synchronized LoggerSynchronizedLazy getInstance(){
        if(instance ==null)
        {
            instance = new LoggerSynchronizedLazy();
        }
        return instance ;
    }
    private void slowdown(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }
    }
    public void log(String message){
        logBuffer.append("").append(message).append("\n");
        System.out.println("");
    }
    public String getLog(){
        return logBuffer.toString();
    }
}
