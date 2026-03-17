package practice.ch02.inheritance;
//client가 원하는 interface를 구현 adpter class 
//implements로 클라이언트가 원하는 메소드 가져오기
public class PrintBannerAdapter extends Banner implements Print{
    
    @Override
    public void printWeak(){
       
        showWithParen(); 
        //메소드라서 항상 앞에 객체.메소드(); 이렇게 호출되어야함
        //생략되면 내 메소드란 뜻이니까
        //extends로 상속을 받음 그럼 내 메소드처럼 쓸수 o 물려받아서
    }
    @Override
    public void printStrong(){
        showWithAster();
    }
}
