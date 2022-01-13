package com.mukzzibba.client.window;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

import com.mukzzibba.client.button.ConfirmInRegisterButton;
import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.NicknameDupCheckButton;
import com.mukzzibba.client.data.RegistData;
import com.mukzzibba.client.data.UserData;

public class RegisterDialog extends Dialog{
	private static final long serialVersionUID = 8949001772274532013L;
	
	Panel p;
	NicknameDupCheckButton dup;
	ConfirmInRegisterButton confirm;
	ExitButton exit;
	
	public RegisterDialog(Frame frame,boolean link) {
		super(frame, link);
		p=new Panel();
//		p.setLayout(null);
		
		UserData.regist=new RegistData();
		UserData.regist.nickname=new TextField("닉네임");
		UserData.regist.password=new TextField("비밀번호");
		
		dup=new NicknameDupCheckButton();
		confirm=new ConfirmInRegisterButton("회원 가입",this);
		exit=new ExitButton("닫기", this);
		
		p.add(UserData.regist.nickname);
		p.add(dup);
		p.add(UserData.regist.password);
		p.add(confirm);
		p.add(exit);
		add(p);
		setBounds(100,100,200,200);
		setVisible(true);
	}
}
