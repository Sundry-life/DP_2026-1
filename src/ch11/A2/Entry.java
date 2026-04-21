package ch11.A2;

public abstract class Entry {
    private Entry parent;

    // 부모를 설정한다
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    // 이름을 가져온다 
    public abstract String getName();

    // 크기를 가져온다 
    public abstract int getSize();

    // 목록을 표시한다 
    public void printList() {
        printList("");
    }

    // prefix를 앞에 붙여 목록을 표시한다
    protected abstract void printList(String prefix);

    // 문자열 표시
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    // 전체 경로를 가져온다 
    public String getFullName() {
        StringBuilder fullname = new StringBuilder(); 
        Entry entry = this; //본인 불러오기 
        do {
            fullname.insert(0, entry.getName()); //0번 위치에 본인 이름
            //insert형식 0번인덱스에 (덮어쓰기x, 0번에 넣고 나머지 원소 뒤로 미루기 st) 
            fullname.insert(0, "/");  
            entry = entry.parent; //부모로 이동
        } while (entry != null); //null이 아닌때 동안, 즉 부모가 없을 때 까지
        return fullname.toString();
    }
}
