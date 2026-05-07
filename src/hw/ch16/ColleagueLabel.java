package hw.ch16;
import java.awt.Label;
import java.awt.Color;
public class ColleagueLabel extends Label implements Colleague {
    private Mediator mediator; 
    @Override
    public void setMediator(Mediator mediator){
        this.mediator = mediator ;
    }
    public ColleagueLabel(String text){
        super(text);
    }

    @Override
    public void setColleagueEnabled(boolean enabled){
       setForeground(enabled ? Color.blue : Color.gray);
       setText(enabled ? "● 로그인 가능" : "● 로그인 불가");
    }
}
