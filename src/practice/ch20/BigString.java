package practice.ch20;

public class BigString {
    // '큰 문자'의 배열
    private BigChar[] bigchars;

    // 생성자 
    public BigString(String string) { //String 들어오면
        BigCharFactory factory = BigCharFactory.getInstance(); //공장 가져오고
        bigchars = new BigChar[string.length()]; // 배열 생성
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i)); //공장을 통해서 BigChar가져와서 배열에 넣기
            //string.charAt(i) = string중에 i번째 문자 얻는 메소드
        }
    }

    // 표시
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print(); 
        }
    }
}
