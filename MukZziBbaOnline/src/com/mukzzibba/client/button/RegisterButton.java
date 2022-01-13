package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.window.ClientFrame;
import com.mukzzibba.client.window.RegisterDialog;

public class RegisterButton extends Button{
	private static final long serialVersionUID = 6337833648868537482L;

	public RegisterButton(String name) {
		super(name);
		addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterDialog(ClientFrame.getInstance(),true);
				
			}
		});
	}
}
