package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.socketNetwork.Login;

public class LogInButton extends ButtonWithSendingMsg{
	
	public LogInButton(String name) {
		super(name, "logi");
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.login();
			}
		});
	}
}
