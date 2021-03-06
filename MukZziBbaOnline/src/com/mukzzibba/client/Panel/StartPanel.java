package com.mukzzibba.client.Panel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	JButton registerButton;
	JButton loginButton;
	JButton exitButton;
	LoginData loginDataToSend;
	
	public StartPanel() {
		frame=ClientFrame.getInstance();
		ImageIcon intro=new ImageIcon(".\\img\\intro.png");
		this.setLayout(new BorderLayout());
		
		Panel northPanel=new Panel();
		
		JPanel centerPanel=new JPanel(new BorderLayout());
		JPanel imagePanel=new JPanel();
		JLabel imageLabel=new JLabel(intro);
		imagePanel.add(imageLabel);
		JPanel loginPanel=new JPanel(new GridLayout(3,2));
		loginPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		
		centerPanel.setBorder(BorderFactory.createEmptyBorder(50,30,0,30));
		centerPanel.add(imagePanel, BorderLayout.NORTH);
		centerPanel.add(loginPanel, BorderLayout.CENTER);
		
		Panel southPanel=new Panel();
		
		
		UserData.login=new LoginData();
		loginDataToSend=UserData.login;
		
		loginDataToSend.nickname=new TextField();
		loginDataToSend.password=new TextField();
		loginDataToSend.password.setEchoChar('*');
		registerButton=new RegisterButton("회원 가입");
		loginButton=new LogInButton("로그인");
		exitButton=new ExitButton("나가기", frame);
		
		loginPanel.add(new Label("닉네임"));
		loginPanel.add(loginDataToSend.nickname);
		loginPanel.add(new Label("비밀번호"));
		loginPanel.add(loginDataToSend.password);
		loginPanel.add(loginButton);
		loginPanel.add(registerButton);

		southPanel.add(exitButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
	}
	
}
