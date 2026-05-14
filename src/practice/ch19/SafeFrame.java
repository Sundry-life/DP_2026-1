package practice.ch19;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent; //버튼 클릭 이벤트
import java.awt.event.ActionListener; //버튼 클릭 이벤트핸들러

public class SafeFrame extends Frame implements ActionListener, Context { //extends Frame으로 프레임으로 만들기
    private TextField textClock = new TextField(60);		// 현재 시간 표시
    private TextArea textScreen = new TextArea(10, 60);	// 경비 센터 출력
    private Button buttonUse = new Button("금고 사용");	// 금고 사용 버튼
    private Button buttonAlarm = new Button("비상벨");	// 비상벨 버튼
    private Button buttonPhone = new Button("일반 통화");	// 일반 통화 버튼
    private Button buttonExit = new Button("종료");		// 종료 버튼

    //제일 중요한 속성. 
    //context가 상태를 가져야하니까. (위임)
    //어차피 처음 시작은 0이니까 Day로 초기화
    private State state = DayState.getInstance();		// 현재 상태 


    // 생성자  //GUI컴포넌트 추가해서 배치하는 거
    public SafeFrame(String title) {
        super(title); //부모생성자 title (항상 부모생성자는 제일 첫문장으로 와야함.)
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClock 배치 
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreen 배치 
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // 패널에 버튼 저장
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // 그 패널을 배치 
        add(panel, BorderLayout.SOUTH);
        // 표시 
        pack();
        setVisible(true);
        // 리스너 설정 
        //this가 actionListener니까.
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    // 버튼이 눌리면 여기로 온다
    //다 this여가지고 버튼 누르면 다 actionPerformed()로 옴
    // 누가 눌렀는지 확인해야함. -> 그래서 정보가 담긴 e로
    //  e.getSource() 해서 어디서 눌렸는지 확인함. 
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) {		// 금고 사용 버튼
            state.doUse(this);  //현재 상태 객체(state)에게 위임해서(주간이면 주간이 야간이면 야간이 일함) <- 가장 중요
            //state가 day인지 night 인지에 따라서
        } else if (e.getSource() == buttonAlarm) {	// 비상벨 버튼 
            state.doAlarm(this); 
        } else if (e.getSource() == buttonPhone) {	// 일반 통화 버튼  
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {	// 종료 버튼 
            System.exit(0); //종료하기
        } else {
            System.out.println("?");
        }
    }

    // 시간 설정 
    @Override
    public void setClock(int hour) { //누군가(시계)가 1초 흘렀다 알려주면 그거 출력
        String clockstring = String.format("현재 시간은 %02d:00", hour); //형식을 갖춘 스트링하려면 String.format이용
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour); //현재 상태한테도 시각 알려줌. 
    }

    // 상태 변화 
    //주간인지 야간인지 state에 바꾼 상태 넣기 
    @Override
    public void changeState(State state) { //인자로 들어온 상태state로 상태this.state 변경하기 
        System.out.println(this.state + "에서" + state + "으로 상태가 변화했습니다.");
        this.state = state;
    }

    // 경비 센터 경비원 호출
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    // 경비 센터 기록 
    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}
