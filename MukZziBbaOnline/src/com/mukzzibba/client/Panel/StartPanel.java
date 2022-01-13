package com.mukzzibba.client.Panel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.LogInButton;
import com.mukzzibba.client.button.RegisterButton;
import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.window.ClientFrame;

public class StartPanel extends Panel{
	private static final long serialVersionUID = 6638658803778634224L;
	
	Frame frame;
	Button registerButton;
	Button loginButton;
	JButton exitButton;
	LoginData loginData;
	
	public StartPanel() {
		frame=ClientFrame.getInstance();
		this.setLayout(new BorderLayout());
		
		JPanel northPanel=new JPanel();
		Panel centerPanel=new Panel();
		Panel southPanel=new Panel();
		
		
		UserData.login=new LoginData();
		loginData=UserData.login;
		
		loginData.nickname=new TextField();
		loginData.password=new TextField();
		registerButton=new RegisterButton("회원 가입");
		loginButton=new LogInButton("로그인");
		exitButton=new ExitButton("나가기", frame);
		
		centerPanel.add(new JLabel("닉네임"));
		centerPanel.add(loginData.nickname);
		centerPanel.add(new Label("비밀 번호"));
		centerPanel.add(loginData.password);
		centerPanel.add(loginButton);
		centerPanel.add(registerButton);

		southPanel.add(exitButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
	}
	
}
