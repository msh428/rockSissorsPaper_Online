package com.mukzzibba.client.button;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.socketNetwork.SignalToServer;

public class ConfirmInRegisterButton extends ExitButton {
	
	public ConfirmInRegisterButton(String name, Window windowForExit) {
		super(name, windowForExit);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignalToServer.sendMsg("regi");
			}
		});
	}
}
