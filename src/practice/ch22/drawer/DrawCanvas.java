package practice.ch22.drawer;

import practice.ch22.command.MacroCommand;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrawCanvas extends Canvas implements Drawable {
    // 그리는 색 
    private Color color = Color.black; //Color에 속한 상수임 / black, red등 이거 상수임
    // 그리는 점의 반지름 
    private int radius = 6;
    // 이력 
    private MacroCommand history; //포함관계ㅡ //명령어집합(명령어 히스토리) 지금까지 그리기 명령들 모아두려고

    // 생성자 
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height); //도화지 크기 
        setBackground(Color.white); //도화지 색상
        this.history = history;  
    }

    // 이력 전체 다시 그리기 
    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    // 그리기 
    @Override
    public void draw(int x, int y) { //좌표에 맞게 실제로 그림 그리기 
        Graphics g = getGraphics(); //그래픽스 객체 얻어와서
        g.setColor(color); //필드변수 색깔로 set
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2); //원을 채움 //그래픽스 객체(g)가 제공
    }
}
