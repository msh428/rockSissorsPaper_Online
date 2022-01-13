package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.socketNetwork.SignalToServer;


public class ButtonWithSendingMsg extends Button{
	private static final long serialVersionUID = -3136411833438833433L;

	public ButtonWithSendingMsg(String name, String msg){
		super(name);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignalToServer.sendMsg(msg);
			}
		});
	}
	
}
