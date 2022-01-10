package com.mukzzibba.client.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.socketNetwork.SignalToServer;
import com.mukzzibba.server.ResultData;

public class DrawButton extends ButtonWithSendingMsg{

	public DrawButton(String name, String msg) {
		super(name, msg);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultData res=SignalToServer.getResultData();
				System.out.println(res);	//..
			}
		});
	}
}