package ch12.A2;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    // 표시 문자열 저장 장소
    private List<String> body = new ArrayList<>();
    // 표시 문자열 최대 문자 수 
    private int columns = 0; //현재 제일 긴 문자열의 길이

    // 문자열 추가 
    public void add(String msg) {
        body.add(msg);
        if (columns < msg.length()) { //더 긴문자열 들어오면,
            // 최대 문자 수 갱신
            columns = msg.length(); //columns에다가 집어넣기 
            // 제일 긴 문자열로 columns 업데이트
        }
        updatePadding(); //다른 문자열도 최고길이 문자열만큼 공백으로 맞추기 //add될때마다 호출됨=들어올때마다 실행
    }
// updatePadding 안하면,
// +-------------+
// |Hi!|
// |Good morning.|
// |Good night!|
// +-------------+
// updatePadding 하면, 
// +-------------+
// |Hi!          |
// |Good morning.|
// |Good night!  |
// +-------------+

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    // 표시 문자열 오른쪽 끝에 채울 공백을 필요에 따라 늘린다
    private void updatePadding() {
        //현재 들어온 문자열에 대해서 ..
        for (int row = 0; row < body.size(); row++) { //int i = 0; i < list.lenght() ; i++ 과 같은 거
            String line = body.get(row); //리스트 원소 가져오기 
            int padding = columns - line.length(); //제일 긴 문자열 길이 - 현재 길이 = 공백 갯수(padding)
            if (padding > 0) {
                body.set(row, line + spaces(padding)); 
                //공백갯수 > 0 이면 sapces호출 후 리스트 원소 수정(set)
                // row 번째에 line과 빈칸을 합쳐서 수정해라. (row = 인덱스)
            }
        }
    }

    // count 수만큼의 공백을 만든다 //공백 문자열 만들기
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        return spaces.toString();
    }
}
