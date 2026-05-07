package practice.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    //Frame = window 창 GUI애플리케이션 만들기 위한
    // ActionListener => 버튼에서 발생하는 이벤트. 
    // 버튼에서 이벤트 발생시 창이 대신 일하는 거.
    // Mediator 중재자 역할을 위한 상속

    //클래스 만든거 토대로 객체 생성하기 
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title);// 항상 부모생성자는 맨 위여야함. 부모 먼저 생성후 자식이니까

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해 4×2 그리드를 만든다 //어떻게 배치할건지 관리하는 객체 
        setLayout(new GridLayout(4, 2)); //그 중 GridLayout방식으로 Grid 즉 표 형태로 (4행 2열)

        // Colleague를 생성한다 
        // 생성했다고 보이는 것은 아님 => 반드시 배치해야 보임. 
        createColleagues(); //이건 길어서 뒤로 뺌. (오버라이드 한거 밑에 있음.)

        // 배치한다 
        // 4X2 그리드에 배치(순서대로)  
        //가로로 순차적으로
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        
        // 활성/비활성 초기 설정을 한다
        colleagueChanged(); 
        //동료들이 상태 바뀌었을 때 중재자에게 호출하는 메소드(핵심)//위임으로 이거 호출하니까.
        

        //반드시 배치된 다음에 표시해주는 메소드 두개 꼭 해줘야함.
        // 표시한다 
        pack(); //배치시킨 UI컴포넌트를 약간 정리시키는 느낌.
        setVisible(true); //show()느낌 true로 줘서 보이게 되는거 
    }

    // Colleague를 생성한다
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true); //초기에 guest가 미리 선택되도록 true
        checkLogin = new ColleagueCheckbox("Login", g, false); 
        //같은 g로 주었기에 똑같은 그룹으로 묶이는거 그래서 하나밖에 선택 안됨


        // TextField
        textUser = new ColleagueTextField("", 10); //디폴트값은 null 그래서 아예 안써있는거
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*'); //pw 입력시 내용 보이지 않고 *로 보이도록 해줌.

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다 //중재자는 본인Frame하나여서 다 this
        //위임으로 동료에 중재자 누구인지 등록시킴
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정
        //본인 등록하도록 (위임활용)
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        //버튼은 중재자로 등록
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) { //if문으로 라디오 버튼 상태 확인하기. 
        // //checkguest가 true이면 즉 gest 로그인이면
            // 게스트 로그인 
            //비활성화해라 (false) / 활성화해라(true) 지시하기
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else { //else일때, => login 클릭된 상태일 때
            // 사용자 로그인 
            textUser.setColleagueEnabled(true);
            userpassChanged();//userpassChange호출하기 
        }
    }

    // textUser 또는 textPass의 변경이 있다 //즉, 입력하는 이벤트가 있을 때.
    // 각 Colleage의 활성/비활성을 판정한다
    private void userpassChanged() {
        if (textUser.getText().length() >= 4) { //login 입력값이 있을 때.
            textPass.setColleagueEnabled(true); //pw입력부분 활성화하기
            if (textPass.getText().length() >= 4) { //pw에도 입력값 있을 때
                buttonOk.setColleagueEnabled(true); //ok 버튼 활성화
            } else {
                buttonOk.setColleagueEnabled(false); //없으면 비활성화
            }
        } else { //login입력값 없을 때 pw와 ok비활성화하기 
            textPass.setColleagueEnabled(false); 
            buttonOk.setColleagueEnabled(false);
        }
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
