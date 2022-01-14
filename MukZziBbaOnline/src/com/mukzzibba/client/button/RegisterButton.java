package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.window.ClientFrame;
import com.mukzzibba.client.window.RegisterFrame;

public class RegisterButton extends JButton{
	private static final long serialVersionUID = 6337833648868537482L;
	
	public RegisterButton(String name) {
		super(name);
		addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterFrame(ClientFrame.getInstance(),true);
				
			}
		});
	}
}
