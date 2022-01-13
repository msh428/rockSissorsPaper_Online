package com.mukzzibba.client.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.window.GameResultDialog;

public class DrawButton extends ButtonWithSendingMsg{
	private static final long serialVersionUID = 2373009524572920076L;

	public DrawButton(String name, String msg) {
		super(name, msg);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GameResultDialog();
			}
		});
	}
}
