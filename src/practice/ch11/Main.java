package practice.ch11;

public class Main {
    public static void main(String[] args) {
        //directory트리 만들기
        //dir 생성
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory usr = new Directory("usr");
        Directory tmp = new Directory("tmp");

        //dir 추가
        root.add(bin);
        root.add(usr);
        root.add(tmp);
        

        //파일 생성 및 추가
        bin.add(new File("vi",10000));
        bin.add(new File("latex",20000));

        //디렉토리 리스트 출력
        root.printList();
    
       
    }
}
