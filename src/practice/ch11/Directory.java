package practice.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) { //확장된 for루프 사용 
            // 형식 => (원소변수: 컬렉션) //컬렉션에서 원소 하나씩 꺼내서 for문 실행
            size += entry.getSize(); 
            //즉, 자식list에서 원소 하나씩 꺼내서 getSize호출 후 리턴값 sum에 더하기
            // getSize호출했더니, 또 getSize호출 됨 = 재귀적 호출
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
