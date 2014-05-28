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
    private Button buttonUse = new Button("금고사용");
    private Button buttonAlarm = new Button("비상벨");
    private Button buttonPhone = new Button("일반 통화");
    private Button buttonExit = new Button("종료");
    
    private State state = DayState.getInstance();
    
    public SafeFrame(String title)
    {
        super(title);
        this.setBackground(Color.lightGray);
        this.setLayout(new BorderLayout());
        
        // textClock 배치
        this.add(this.textClock, BorderLayout.NORTH);
        this.textClock.setEditable(false);
        
        // textScreen 배치
        this.add(this.textScreen, BorderLayout.CENTER);
        this.textScreen.setEditable(false);
        
        // 패널에 버튼을 보관
        Panel panel = new Panel();
        panel.add(this.buttonUse);
        panel.add(this.buttonAlarm);
        panel.add(this.buttonPhone);
        panel.add(this.buttonExit);
        
        // 패널을 배치
        this.add(panel, BorderLayout.SOUTH);
        
        // 표시
        this.pack();
        this.show();
        
        // 리스너 설정
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
    
    // 시각의 설정
    public void setClock(int hour)
    {
        String clockString = "현재 시각은 ";
        if (hour < 10) {
            clockString += "0" + hour + ":00";
        } else {
            clockString += hour + ":00";
        }
        System.out.println(clockString);
        this.textClock.setText(clockString);
        this.state.doClock(this, hour);
    }
    
    // 상태 변화
    public void changeState(State state)
    {
        System.out.println(this.state + "에서 " + state + "로 상태가 바뀌었습니다.");
        this.state = state;
    }
    
    // 경비센터 호출
    public void callSecurityCenter(String msg)
    {
        this.textScreen.append("call! " + msg + "\n");
    }
    
    // 경비센터 기록
    public void recordLog(String msg)
    {
        this.textScreen.append("record ... " + msg + "\n");
    }
}
