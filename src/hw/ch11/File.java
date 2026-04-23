package hw.ch11;
import java.util.ArrayList;
import java.util.List;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    protected List<Entry> search(String keyword){
        List<Entry> e = new ArrayList<>();
        if((this.name).contains(keyword))//포함됏는지)
        {
            e.add(this); 
        }
        return e; 
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
