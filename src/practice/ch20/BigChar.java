package practice.ch20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// 파일에서 큰 문자 데이터를 읽어들임.
public class BigChar {
    // 문자의 이름 
    private char charname;
    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    private String fontdata;

    // 생성자 
    public BigChar(char charname) { //인자 (가령3)이 들어오면,
        this.charname = charname; 
        try {
            String filename = "big" + charname + ".txt"; //파일명
            StringBuilder sb = new StringBuilder(); 
            for (String line: Files.readAllLines(Paths.get(filename))) { //파일 관련된 일 -> Files 클래스 이용
               //readAllLines = 모두 읽어와라 
               //Path라는 클래스 => 경로를 관리하는 클래스
               //Path.of(filename): 생성자 메소드에 of가 있음 -> filename으로 경로 만들어주는 거
               //List<String>구조로 반환됨. 
               //그래서 for문은 String line(원소) : List<String>(집합체) 인 것
                sb.append(line); // StringBuilder sb에 한줄 씩 추가.
                sb.append("\n"); //줄바꿈. 
            }
            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?"; //못찾으면
        }
    }

    // 큰 문자를 표시한다
    public void print() {
        System.out.print(fontdata);
    }
}
