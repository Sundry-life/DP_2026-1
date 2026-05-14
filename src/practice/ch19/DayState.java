package practice.ch19;

public class DayState implements State {
    private static DayState singleton = new DayState();

    private DayState() {
    }

    public synchronized static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) { //시간을 받아서 
        if (hour < 9 || 17 <= hour) { //현재 시간이 야간이라면
            context.changeState(NightState.getInstance()); //context한테 바꿔라고 얘기하기 (인자로 nightstate 객체)
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }
}
