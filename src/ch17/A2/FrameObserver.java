package ch17.A2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameObserver extends Frame implements Observer, ActionListener {
    // GraphText는 통지된 수를 텍스트 필드로 표시하는 static 클래스 
    //클래스 안에 또다른 클래스 (frameObserver안에서만 사용되는 클래스) => 이런걸 static 클래스라고 함. 
    static class GraphText extends TextField implements Observer {
        public GraphText(int columns) {
            super(columns);
        }

        @Override
        public void update(NumberGenerator generator) {
            int number = generator.getNumber();
            String text = number + ":";
            for (int i = 0; i < number; i++) {
                text += '*';
            }
            setText(text); //Textfield에 text출력하기 (즉 setText 메소드는 textfield의 메소드임.)
        }
    }

    // GraphCanvas는 통지된 수를 원그래프로 표시하는 static 클래스 
    static class GraphCanvas extends Canvas implements Observer {
        private int number;

        //
        @Override
        public void update(NumberGenerator generator) {
            number = generator.getNumber(); //subject변경사항 가져오기
            repaint();  //도화지 리셋하고 paint()메소드를 호출함.
        }

        public void paint(Graphics g) { //Graphics인자 통해서 paint
            int width = getWidth(); //도화지 크기 얻어오기 
            int height = getHeight();
            g.setColor(Color.white); //흰색으로 색상 선택
            g.fillArc(0, 0, width, height, 0, 360); //그리기
            g.setColor(Color.red); //빨강 으로 선택
            g.fillArc(0, 0, width, height, 90, - number * 360 / 50); //그리기 
        }
    }

    //구성요소 3개 만들어서 
    private GraphText textGraph = new GraphText(60);
    private GraphCanvas canvasGraph = new GraphCanvas();
    private Button buttonClose = new Button("Close");

    public FrameObserver() { //생성자에 집어넣기 
        super("FrameObserver"); // 창의 이름 - super는 상속받은 Frame에 해당
        setLayout(new BorderLayout()); //레이아웃은 BorderLayout
        setBackground(Color.lightGray); //프레임의 배경색
        textGraph.setEditable(false); //텍스트 필드는 수정 불가능으로 
        canvasGraph.setSize(500, 500); // 그림 사이즈
        add(textGraph, BorderLayout.NORTH); //북
        add(canvasGraph, BorderLayout.CENTER); //중앙
        add(buttonClose, BorderLayout.SOUTH); //남쪽
        buttonClose.addActionListener(this); //동작 리스너(프레임 눌리면 얘가 이벤트 처리) > buttonClose
        pack(); //정리
        setVisible(true); //화면 출력show()
    }

    @Override
    public void actionPerformed(ActionEvent e) { //close버튼 클릭시 실행됨
        System.out.println(e.toString());
        System.exit(0); //프로그램 종료 방법
    }

    @Override  //Canvus랑 text에다가 update 토스함 
    public void update(NumberGenerator generator) {
        textGraph.update(generator);
        canvasGraph.update(generator);
    }
}

