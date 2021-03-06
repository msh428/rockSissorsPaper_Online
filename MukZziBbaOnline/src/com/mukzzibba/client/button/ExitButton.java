package com.mukzzibba.client.button;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ExitButton extends JButton implements ActionListener{
	private static final long serialVersionUID = -1218573886899339630L;
	
	Window windowToExit;
	
	public ExitButton(String name, Window window) {
		super(name);
		windowToExit=window;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		windowToExit.dispose();
	}
}
