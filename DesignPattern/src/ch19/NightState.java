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
        context.recordLog("���: �߰��� �ݰ� ���");
    }
    
    public void doAlarm(Context context)
    {
        context.callSecurityCenter("���(�߰�)");
    }
    
    public void doPhone(Context context)
    {
        context.callSecurityCenter("�߰��� ��ȭ ����");
    }
    
    public String toSTring()
    {
        return "[�߰�]";
    }
}
