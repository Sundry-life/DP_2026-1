package practice.ch03; 
//부모 
public abstract class AbstractDisplay {
    // open, print, close는 하위 클래스에 구현을 맡기는 추상 메소드 
    public abstract void open();
    public abstract void print();
    public abstract void close(); 

    // display는 AbstractDisplay에서 구현하는 메소드 
    //큰 틀을 제공함. ->but, open, print, close가 어떻게 하는냐에 따라서 달라짐. 
    //구멍만 뚫어든 자 -> 실제 어떤 색상, 어떤 펜 등 인지는 모름. 
    //이런 메소드를 탬플릿 메소드라고 함. 구멍 뚫린 
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
