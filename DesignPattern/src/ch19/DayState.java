package ch19;

public class DayState implements State
{
    private static DayState singleton = new DayState();
    
    private DayState() {}
    
    public static State getInstance()
    {
        return singleton;
    }
    
    public void doClock(Context context, int hour)
    {
        if (hour < 9 || hour >= 17) {
            context.changeState(NightState.getInstance());
        }
    }
    
    public void doUse(Context context)
    {
        context.recordLog("�ݰ���(�ְ�)");
    }
    
    public void doAlarm(Context context)
    {
        context.callSecurityCenter("���(�ְ�)");
    }
    
    public void doPhone(Context context)
    {
        context.callSecurityCenter("�Ϲ���ȭ(�ְ�)");
    }
    
    public String toSTring()
    {
        return "[�ְ�]";
    }
}
