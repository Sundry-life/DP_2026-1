package practice.ch16;

import java.awt.Checkbox; //checkbox 가져오기
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
    // Checkbox 상속 / ItemListener 상속해서 이벤트 핸들러 작성할 수 있도록 함.
    // colleague 상속
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state); 
        //caption = 문자열(guest,login)
        //하나만 선택되어야하니까 같은 그룹으로 설정이 필요 
        //state = 디폴트로 이미 선택되어있는 상태일지 말지 그런거 결정하는거.
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
    }

    @Override //이벤트 리스너
    public void itemStateChanged(ItemEvent e) { 
        // 상태가 변화하면 Mediator에 알린다
        mediator.colleagueChanged();//상태 바뀌었다고 보고
    }
}
