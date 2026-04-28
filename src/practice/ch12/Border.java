package practice.ch12;

public abstract class Border extends Display { //장식자 클래스 
    protected Display display;    //장식 대상 (=이 장식틀이 감싸는 '내용물') 
    // //부모 타입이라서 display는 누구든 올 수 있음


    protected Border(Display display) { // 인스턴스 생성 시 '내용물'을 인수로 지정 //생성자 메소드
        this.display = display;
    }
}
