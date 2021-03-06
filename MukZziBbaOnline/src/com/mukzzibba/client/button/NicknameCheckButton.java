package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mukzzibba.client.cheker.NameChecker;
import com.mukzzibba.client.socketNetwork.SignalToServer;
import com.mukzzibba.client.window.ClientFrame;
import com.mukzzibba.client.window.ErrorDialog;

public class NicknameCheckButton extends JButton {
	private static final long serialVersionUID = -6313655508555498131L;

	public NicknameCheckButton() {
		super("중복 확인");
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!NameChecker.nicknameValidation()){
					new ErrorDialog("닉네임 규칙을 확인해주세요");
					return ;
				}
				SignalToServer.sendMsg("dupC");
			}
		});
	}
	
}
