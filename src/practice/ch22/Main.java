package practice.ch22;

import practice.ch22.command.*;
import practice.ch22.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);//캔버스
    // 삭제 버튼
    private JButton clearButton  = new JButton("clear"); //버튼

    // 생성자 
    public Main(String title) {
        super(title);
        //리스너 등록
        this.addWindowListener(this); //Main에 오버라이딩했음. 그래서 this로 이동
        canvas.addMouseMotionListener(this); //마우스 리스너도 Main에서 작성해둬서 this로(내가 일을 한다.)
        clearButton.addActionListener(e -> { //람다함수로 여기다가 아예 바로 이거 하라고 작성 / this로 등록하고 오버라이딩으로 따로 빼도 ok
            history.clear(); //이력삭제 
            canvas.repaint(); //전체 다시 그리기 -> paint()호출 -> history.excute()호출 -> 아무것도 없어서 안 그리게 됨 
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS); //가로배치하는 박스 생성
        buttonBox.add(clearButton); //클리어 버튼추가
        Box mainBox = new Box(BoxLayout.Y_AXIS); //main은 세로 배치해라 박스
        mainBox.add(buttonBox);
        mainBox.add(canvas); 
        getContentPane().add(mainBox); 

        pack();
        setVisible(true);
    }

    // MouseMotionListener용
    @Override //그냥 움직일 때 -> 처리 없음
    public void mouseMoved(MouseEvent e) { 
        //  System.out.println("Mouse point : "+e.getPoint()); //마우스 위치 확인 
    }
    @Override //누르면서 움직임 //command
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint()); //그리기 명령 객체 생성 //명령 정보 제공 (어떤 캔버스, 어떤 좌표)
        history.append(cmd);//그리기 명령을 history에 추가
        cmd.execute();//그리기 명령 실행함.
    }

    // WindowListener용 
    @Override
    public void windowClosing(WindowEvent e) { // x 누르면 창 끄기 
        System.exit(0); //이거 없어도 x 버튼 눌러도 창 사라지긴 함. 
        // 종료된 것처럼 보이지만, 사실 윈도우창만 사라진거지 종료된건 아님 (터미널 종료 표시 없고 vscode에 stop버튼 그거 계속 떠있음.)
    }
    //나머지 windowlistener은 필요 없어서 다 빈칸
    @Override public void windowActivated(WindowEvent e) {} // 윈도우가 FG (포커스)얻었을 때
    @Override public void windowClosed(WindowEvent e) {} //윈도우 창 사라졌을 때?
    @Override public void windowDeactivated(WindowEvent e) {} //윈도우가 BG (포커스) 잃었을 때
    @Override public void windowDeiconified(WindowEvent e) {}// 축소화된 창 다시 열었을 때
    @Override public void windowIconified(WindowEvent e) {} //창 축소화해서 없어졌을 때 / icon 아이콘 //그니까 [-]눌렀을 때
    @Override public void windowOpened(WindowEvent e) {} //윈도우 창 오픈했을 때

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
