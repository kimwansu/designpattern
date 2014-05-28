package ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator
{
    private static final long serialVersionUID = -3480228167407046371L;
    
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;
    
    public LoginFrame(String title)
    {
        super(title);
        this.setBackground(Color.lightGray);
        // 레이아웃 매니저를 사용하여 4×2의 그리드 생성
        this.setLayout(new GridLayout(4, 2));
        
        // 배치
        this.createColleagues();
        this.add(this.checkGuest);
        this.add(this.checkLogin);
        this.add(new Label("Username:"));
        this.add(this.textUser);
        this.add(new Label("Password:"));
        this.add(this.textPass);
        this.add(this.buttonOk);
        this.add(this.buttonCancel);
        
        // 유효/무효의 초기 지정
        this.colleagueChanged(this.checkGuest);
        
        // 표시
        this.pack();
        this.show();
    }
    
    public void createColleagues()
    {
        // 생성
        CheckboxGroup g = new CheckboxGroup();
        this.checkGuest = new ColleagueCheckbox("Guest", g, true);
        this.checkLogin = new ColleagueCheckbox("Login", g, true);
        this.textUser = new ColleagueTextField("", 10);
        this.textPass = new ColleagueTextField("", 10);
        this.textPass.setEchoChar('*');
        this.buttonOk = new ColleagueButton("OK");
        this.buttonCancel = new ColleagueButton("Cancel");
        
        // Mediator의 세트
        this.checkGuest.setMediator(this);
        this.checkLogin.setMediator(this);
        this.textUser.setMediator(this);
        this.textPass.setMediator(this);
        this.buttonOk.setMediator(this);
        this.buttonCancel.setMediator(this);
        
        // Lisener의 세트
        this.checkGuest.addItemListener(this.checkGuest);
        this.checkLogin.addItemListener(this.checkLogin);
        this.textUser.addTextListener(this.textUser);
        this.textPass.addTextListener(this.textPass);
        this.buttonOk.addActionListener(this);
        this.buttonCancel.addActionListener(this);
    }
    
    // Colleague로부터 통지로 각 Colleague의 유효/무효 판정
    public void colleagueChanged(Colleague c)
    {
        if (c == this.checkGuest || c == this.checkLogin) {
            if (this.checkGuest.getState()) {
                // Guest 모드
                this.textUser.setColleagueEnabled(false);
                this.textPass.setColleagueEnabled(false);
                this.buttonOk.setColleagueEnabled(true);
            } else {
                // Login 모드
                this.textUser.setColleagueEnabled(true);
                this.userPassChanged();
            }
        } else if (c == this.textUser || c == this.textPass){
            this.userPassChanged();
        } else {
            System.out.println("colleagueChanged:unknown colleague = " + c);
        }
    }
    
    // textUser 또는 textPass의 변경이 있을 때 각 Colleague의 유효/무효 판정
    private void userPassChanged()
    {
        if (this.textUser.getText().length() > 0) {
            this.textPass.setColleagueEnabled(true);
            if (this.textPass.getText().length() >= 4 && this.textUser.getText().length() >= 4) {
                this.buttonOk.setColleagueEnabled(true);
            } else {
                this.buttonOk.setColleagueEnabled(false);
            }
        } else {
            this.textPass.setColleagueEnabled(false);
            this.buttonOk.setColleagueEnabled(false);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e);
        System.exit(0);
    }
}
