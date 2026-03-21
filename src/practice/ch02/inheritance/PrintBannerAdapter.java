package practice.ch02.inheritance;
//client가 원하는 interface를 구현 adpter class 
//implements로 클라이언트가 원하는 메소드 가져오기
public class PrintBannerAdapter extends Banner implements Print{
    //입력 받아줄 생성자가 필요함. 
    //부모에게 물려받는거 아님?
    //1)인자 없는 생성자는 자동으로 생성 ok
    //2)생성자는 상속되지 않음 !
    public PrintBannerAdapter(String text){
        super(text); //super로 부모 생성자 호출
    }
    @Override
    public void printWeak(){
        //원래 객체.메소드 인데 객체 생략 됨=this생략 인거
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
