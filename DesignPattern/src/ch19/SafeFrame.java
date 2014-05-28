package ch19;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context
{
    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10, 60);
    private Button buttonUse = new Button("�ݰ���");
    private Button buttonAlarm = new Button("���");
    private Button buttonPhone = new Button("�Ϲ� ��ȭ");
    private Button buttonExit = new Button("����");
    
    private State state = DayState.getInstance();
    
    public SafeFrame(String title)
    {
        super(title);
        this.setBackground(Color.lightGray);
        this.setLayout(new BorderLayout());
        
        // textClock ��ġ
        this.add(this.textClock, BorderLayout.NORTH);
        this.textClock.setEditable(false);
        
        // textScreen ��ġ
        this.add(this.textScreen, BorderLayout.CENTER);
        this.textScreen.setEditable(false);
        
        // �гο� ��ư�� ����
        Panel panel = new Panel();
        panel.add(this.buttonUse);
        panel.add(this.buttonAlarm);
        panel.add(this.buttonPhone);
        panel.add(this.buttonExit);
        
        // �г��� ��ġ
        this.add(panel, BorderLayout.SOUTH);
        
        // ǥ��
        this.pack();
        this.show();
        
        // ������ ����
        this.buttonUse.addActionListener(this);
        this.buttonAlarm.addActionListener(this);
        this.buttonPhone.addActionListener(this);
        this.buttonExit.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        System.out.println(event);
        if (event.getSource() == this.buttonUse){
            state.doUse(this);
        } else if (event.getSource() == this.buttonAlarm) {
            state.doAlarm(this);
        } else if (event.getSource() == this.buttonPhone){
            state.doPhone(this);
        } else if (event.getSource() == this.buttonExit) {
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }
    
    // �ð��� ����
    public void setClock(int hour)
    {
        String clockString = "���� �ð��� ";
        if (hour < 10) {
            clockString += "0" + hour + ":00";
        } else {
            clockString += hour + ":00";
        }
        System.out.println(clockString);
        this.textClock.setText(clockString);
        this.state.doClock(this, hour);
    }
    
    // ���� ��ȭ
    public void changeState(State state)
    {
        System.out.println(this.state + "���� " + state + "�� ���°� �ٲ�����ϴ�.");
        this.state = state;
    }
    
    // ����� ȣ��
    public void callSecurityCenter(String msg)
    {
        this.textScreen.append("call! " + msg + "\n");
    }
    
    // ����� ���
    public void recordLog(String msg)
    {
        this.textScreen.append("record ... " + msg + "\n");
    }
}
