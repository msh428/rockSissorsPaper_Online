package com.mukzzibba.client.window;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

import com.mukzzibba.client.button.ConfirmInRegisterButton;
import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.NicknameDupCheckButton;

public class RegisterDialog extends Dialog{
	Panel p;
	TextField nickname;
	TextField password;
	NicknameDupCheckButton dup;
	ConfirmInRegisterButton confirm;
	ExitButton exit;
	
	public RegisterDialog(Frame frame,boolean link) {
		super(frame, link);
		p=new Panel();
//		p.setLayout(null);
		
		nickname=new TextField("닉네임");
		password=new TextField("비밀번호");
		dup=new NicknameDupCheckButton();
		confirm=new ConfirmInRegisterButton("확인",this);
		exit=new ExitButton("닫기", this);
		
		p.add(nickname);
		p.add(dup);
		p.add(password);
		p.add(confirm);
		p.add(exit);
		add(p);
		setBounds(100,100,200,200);
		setVisible(true);
	}
}
