package com.mukzzibba.client.window;

import java.awt.Dialog;
import java.awt.Label;
import java.awt.Panel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.server.ResultData;

public class GameResultDialog extends Dialog{
	private static final long serialVersionUID = 3208370987402624793L;
	
	Panel p;
	Label resultLabel;
	ResultData user;
	
	public GameResultDialog() {
		super(ClientFrame.getInstance(),true);
		p=new Panel();
		resultLabel=new Label();
		user=UserData.result;
		resultLabel.setText(user.userStr+" "+user.comStr+" "+user.result);
		
		p.add(resultLabel);
		p.add(new ExitButton("�ݱ�", this));
		add(p);
		setBounds(100,100,200,200);
		setVisible(true);
	}
}
