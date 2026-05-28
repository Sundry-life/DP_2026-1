package practice.ch14;

public abstract class Support { 
    private String name;    // 이 트러블 해결자 이름
    private Support next;   // 떠넘길 곳(자기 뒷 사람) 
    // 부모인 Support 타입 => 모든 자식(해결자) 가리킬 수 있다.

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    // 떠넘길 곳을 설정한다
    public Support setNext(Support next) { //인자 부모타입 => 모든 해결자 인자로 받을 수 있음.
        this.next = next; //설정 후 
        return next; //뒷사람을 리턴
    }

    // 트러블 해결 절차를 결정한다 support 
    public void support(Trouble trouble) { 
        if (resolve(trouble)) { //내가 해결을 시도
            done(trouble); //resolve가 T면 done 성공하면 해결했다 선언
        } else if (next != null) { //내가 해결 못하고 뒷사람이 있으면 전달.
            next.support(trouble); //뒷사람한테 떠넘김.
        } else {
            fail(trouble);//해결 못했는데 뒷사람도 없음 => 해결 실패 
        }
    }

    // 트러블 해결자의 문자열 표현
    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 해결하려고 한다 //추상 메소드 resolve 
    protected abstract boolean resolve(Trouble trouble);

    // 해결했다 
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    // 해결되지 않았다 
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
