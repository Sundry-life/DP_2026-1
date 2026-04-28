package practice.ch12;

public abstract class Display { //장식 대상(장식자, 중심)을 나타내는 클래스 
    public abstract int getColumns();           	// 가로 문자 수를 얻는다
    public abstract int getRows();              	// 세로 행수를 얻는다 //행 갯수 : 1개 2개 3개 ....
    public abstract String getRowText(int row); 	// row행째 문자열을 얻는다 // 0번째 1번째 2번째...(index느낌)

    // 모든 행을 표시한다(템플릿 메소드)
    public void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i)); //한 행씩 출력
        }
    }
}
