package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends ButtonWithSendingMsg implements ActionListener{
	Window windowToExit;
	
	public ExitButton(String name, Window window) {
		super(name, "exit");
		windowToExit=window;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		windowToExit.dispose();
	}
}
