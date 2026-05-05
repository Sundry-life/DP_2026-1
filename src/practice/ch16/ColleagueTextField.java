package practice.ch16;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator; 
    //텍스트 필드 자체가 리스너 역할까지 하도록(간단하게) 그래서 TextField뿐만 아니라 TextListener까지 상속받음

    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        // 활성/비활성에 맞게 배경색을 변경한다
        setBackground(enabled ? Color.white : Color.lightGray); //부모인 TextField에 있는 setBackground =색 지정
        // (조건문) ? (T일때 값) : (F일때 값)
        //Color라는 enum class에 상수 white, lightgray임. 
    }

    @Override //TextListener에 있는 이벤트 핸들러 구현
    public void textValueChanged(TextEvent e) {
        // 문자열이 변화했으면 Mediator에 알린다
        mediator.colleagueChanged();//위임으로 보고
        //입력될때마다(문자열 변화할때마다 보고함)
        // 즉 리스너에다가 중재자에게 보고하는 메소드 작성 필요 (리스너 = 이벤트 발생했다는 뜻이니까..)
    }
}
