package com.mukzzibba.client.button;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mukzzibba.client.cheker.PassChecker;
import com.mukzzibba.client.socketNetwork.SignalToServer;
import com.mukzzibba.client.window.ErrorDialog;

public class ConfirmInRegisterButton extends JButton{
	private static final long serialVersionUID = 6074502414775671090L;
	
	
	public ConfirmInRegisterButton(String name, Window windowForExit) {
		super(name);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!PassChecker.passValidation()){
					if(PassChecker.passNumError()){
						new ErrorDialog("비밀 번호 규칙을 확인해주세요");						
					} else {
						new ErrorDialog("비밀번호가 일치하지 않습니다");
					}
					return ;
				}
				SignalToServer.sendMsg("regi");
			}
		});
		
		setEnabled(true);
		
	}
}
