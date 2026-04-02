package hw.ch05;

public enum LoggerEnum {
    INSTANCE; 
    private StringBuilder logBuffer; 
    private LoggerEnum(){
        System.out.println("LoggerEnum 인스턴스 생성했습니다.");
        logBuffer = new StringBuilder(); 
    }
    

    public void log(String message){
        logBuffer.append("").append(message).append("\n");
        System.out.println("");
    }
    public String getLog(){
        return logBuffer.toString();
    }
}
