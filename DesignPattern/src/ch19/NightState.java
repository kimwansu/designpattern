package ch19;

public class NightState implements State
{
    private static NightState singleton = new NightState();
    
    private NightState() {}
    
    public static State getInstance()
    {
        return singleton;
    }
    
    public void doClock(Context context, int hour)
    {
        if (hour >= 9 || hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    
    public void doUse(Context context)
    {
        context.recordLog("비상: 야간의 금고 사용");
    }
    
    public void doAlarm(Context context)
    {
        context.callSecurityCenter("비상벨(야간)");
    }
    
    public void doPhone(Context context)
    {
        context.callSecurityCenter("야간의 통화 녹음");
    }
    
    public String toSTring()
    {
        return "[야간]";
    }
}
