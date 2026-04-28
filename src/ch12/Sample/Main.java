package ch12.Sample;

public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world."); //중심
        Display b2 = new SideBorder(b1, '#'); //장식자 1
        Display b3 = new FullBorder(b2); // 장식자 2 (차근차근 장식함)
        b1.show();
        b2.show();
        b3.show();
        Display b4 = //다양한 조합으로 장식 (한꺼번에 생성/체이닝메소드)
                    new SideBorder( //장식5
                        new FullBorder( //장식4
                            new FullBorder( //장식3
                                new SideBorder( //장식2
                                    new FullBorder( //장식1
                                        new StringDisplay("Hello, world.") //중심
                                    ),
                                    '*'
                                )
                            )
                        ),
                        '/'
                    );
        b4.show();
    }
}
