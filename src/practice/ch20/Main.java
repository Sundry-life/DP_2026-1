package practice.ch20;

public class Main {
    public static void main(String[] args) {

        System.out.println("BigChar이용\n");
        //char1과 char2는 다른 인스턴스(객체) 이나 동일한 내용임 = 낭비됨
        BigChar char1 = new BigChar('1');
        char1.print();

        BigChar char2 = new BigChar('1');
        char2.print();
         if(char1==char2){
            System.out.println("같은 인스턴스");
        }
        else{
            System.out.println("다른 인스턴스");
        }



        System.out.println("\nBigFactory이용\n");


        BigCharFactory factory = BigCharFactory.getInstance();
        BigChar char3  = factory.getBigChar('2');
        char3.print();
        BigChar char4 = factory.getBigChar('2');
        char4.print();
        if(char3==char4){
            System.out.println("같은 인스턴스");
        }
        else{
            System.out.println("다른 인스턴스");
        }


        System.out.println("\nBigString이용\n");


        BigString bigstr = new BigString("991");
        bigstr.print();

    }
}
