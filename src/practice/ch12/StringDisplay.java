package practice.ch12;

public class StringDisplay extends Display { //중심 컴포넌트(leaf) //문자열 표시 //display상속
    private String string; // 표시 문자열 

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() { // 가로 문자 수를 얻는다
        return string.length(); //column = string 길이
    }

    @Override
    public int getRows() { // 세로 행수를 얻는다
        return 1; // 행수는 1 row 
    }

    @Override
    public String getRowText(int row) { // row행째 문자열을 얻는다
        if (row != 0) {   
            //hello world => 1행 뿐이니까 show 에서 for (int i =0; i< getRow; i++) 하면 i = 0 번째 => hello world
            // 1,2,...번째는 오류 메세지로 중단 => 끝 //그래서 row != 0 임
            throw new IndexOutOfBoundsException(); //배열 범위 넘어섰다는 오류 메세지
        }
        return string; 
    }
}
