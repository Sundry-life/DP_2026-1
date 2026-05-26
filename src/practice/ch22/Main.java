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
            history.clear(); 
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
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    // WindowListener용 
    @Override
    public void windowClosing(WindowEvent e) { // x 누르면 창 끄기 
        System.exit(0);
    }
    //나머지 windowlistener은 필요 없어서 다 빈칸
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
