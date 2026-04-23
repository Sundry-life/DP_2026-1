package hw.ch11;
import java.util.ArrayList;
import java.util.List;

public abstract class Entry {
    // 이름을 얻는다
    public abstract String getName();

    // 크기를 얻는다 
    public abstract int getSize();

    // 목록을 표시한다
    public void printList() {
        printList("");
    }
    private Entry parent;

    // 부모를 설정한다
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    // prefix를 앞에 붙여서 목록을 표시한다 
    protected abstract void printList(String prefix);
    
    protected abstract List<Entry> search(String keyword);

    // 문자열 표시 
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
    
     public String getFullName() {
        StringBuilder fullname = new StringBuilder();
        Entry entry = this; //
        do {
            fullname.insert(0, entry.getName());
            fullname.insert(0, "/");
            entry = entry.parent; //부모로 이동
        } while (entry != null); //null이 아닌때 동안, 즉 부모가 없을 때 까지
        return fullname.toString();
    }
}
