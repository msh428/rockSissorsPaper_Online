package com.mukzzibba.client.action;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.window.ClientFrame;
import com.mukzzibba.client.window.RegisterDialog;

public class RegisterAction implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new RegisterDialog(ClientFrame.getInstance(),true);
		
	}
	
}