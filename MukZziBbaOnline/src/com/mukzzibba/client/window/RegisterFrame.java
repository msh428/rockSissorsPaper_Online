package com.mukzzibba.client.window;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mukzzibba.client.button.ConfirmInRegisterButton;
import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.NicknameCheckButton;
import com.mukzzibba.client.data.RegistData;
import com.mukzzibba.client.data.UserData;

public class RegisterFrame extends Frame{
	private static final long serialVersionUID = 8949001772274532013L;
	
	JPanel p;
	TextField nickname;
	TextField password;
	TextField passwordAgain;
	NicknameCheckButton nameCheckButton;
	ConfirmInRegisterButton confirm;
	ExitButton exit;
	Label namingRule;
	Label passRule;
	
	public RegisterFrame(Frame frame,boolean link) {
		super();
		p=new JPanel(new BorderLayout());
		p.setBorder(BorderFactory.createEmptyBorder(10,10,0,0));
		
		Panel centerPanel=new Panel(new GridLayout(5,1));
		Panel southPanel=new Panel();
		
		UserData.regist=new RegistData();
		UserData.regist.nickname=new TextField("");
		UserData.regist.password=new TextField("");
		UserData.regist.password.setEchoChar('*');
		UserData.regist.passwordAgain=new TextField("");
		UserData.regist.passwordAgain.setEchoChar('*');
		
		nickname=UserData.regist.nickname;
		password=UserData.regist.password;
		passwordAgain=UserData.regist.passwordAgain;

		nameCheckButton=new NicknameCheckButton();
		confirm=new ConfirmInRegisterButton("ȸ�� ����",this);
		namingRule=new Label("���̵� 2-8 ���� ,���� �Ұ�");
		passRule=new Label("��й�ȣ 4-16 ����");
		exit=new ExitButton("�ݱ�", this);
		
		
		Panel center1=new Panel(new BorderLayout());
		center1.add(new Label("�г���             "), BorderLayout.WEST);
		center1.add(nickname);
		center1.add(nameCheckButton, BorderLayout.EAST);
		JPanel center2=new JPanel(new BorderLayout());
		center2.add(new Label("��й�ȣ         "), BorderLayout.WEST);
		center2.add(password);
		Panel center3=new Panel(new BorderLayout());
		center3.add(new Label("��й�ȣ Ȯ��"), BorderLayout.WEST);
		center3.add(passwordAgain);
		Panel center4=new Panel();
		center4.add(namingRule);
		Panel center5=new Panel();
		center5.add(passRule);
		
		centerPanel.add(center1);
		centerPanel.add(center2);
		centerPanel.add(center3);
		centerPanel.add(center4);
		centerPanel.add(center5);
		
		southPanel.add(confirm);
		southPanel.add(exit);
		
		p.add(centerPanel, BorderLayout.CENTER);
		p.add(southPanel, BorderLayout.SOUTH);
		add(p);
		setBounds(100,100,300,200);
		setVisible(true);
	}
}