package practice.ch06;

public class Main {
    public static void main(String[] args) {
        MessageBox mbox1= new MessageBox('*');
        mbox1.use("hello world");

        mbox1.createCopy().use("Hello world"); // *를 넣지 않았지만, 복사되어서 똑같이 나옴. 
        //그리고 첫줄 mbox의 *를 바꾸면 똑같이 바뀜 
    }
}
