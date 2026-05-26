package practice.ch22.command;
//명령을 나타내는 인터페이스
public interface Command {
    public abstract void execute(); // 명령하면 어떤 일 할지 자식이 구현
}
