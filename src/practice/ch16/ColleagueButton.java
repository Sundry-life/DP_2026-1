package practice.ch16;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    //Button을 상속받음 java.awt에 있는거
    //colleague 인터페이스 상속받음

    private Mediator mediator; //위임

    public ColleagueButton(String caption) {
        super(caption); //caption = 버튼에 나타나는 글자. ( OK/ Cancel)
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled); //부모인 Button 에 setEnabled()호출하는 거 
    }
}
