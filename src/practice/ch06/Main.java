package practice.ch06;
import practice.ch06.framework.Manager;
import practice.ch06.framework.Product;
public class Main {
    public static void main(String[] args) {
        // //원본 prototype이 일함
        // MessageBox mbox1= new MessageBox('*');
        // mbox1.use("hello world");

        // //복제된 객체가 일함. 
        // mbox1.createCopy().use("Hello world"); // *를 넣지 않았지만, 복사되어서 똑같이 나옴. 
        // //그리고 첫줄 mbox의 *를 바꾸면 똑같이 바뀜 


        // //원본
        // UnderlinePen upen1 = new UnderlinePen('~');
        // upen1.use("hello world!");
        // //복제
        // upen1.createCopy().use("Hello world!");

        //Manager이용
        //준비
        Manager manager = new Manager();
        MessageBox messageBox = new MessageBox('*');
        MessageBox messageBox2 = new MessageBox('/');
        UnderlinePen upen = new UnderlinePen('~');
        //등록
        manager.register("star message",messageBox);
        manager.register("slash message", messageBox2);
        manager.register("underline",upen);
        //등록된 이름으로 복제품 얻어서 사용
        Product p1 = manager.create("star message");
        p1.use("manager : star message");
        Product p2 = manager.create("slash message");
        p2.use("manager : slash message");
        Product p3 = manager.create("underline");
        p3.use("manager : underline");

    }
}
