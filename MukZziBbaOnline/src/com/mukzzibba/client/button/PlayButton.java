package com.mukzzibba.client.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.controller.PanelController;

public class PlayButton extends ButtonWithSendingMsg{
	
	public PlayButton(String name) {
		super(name, "play");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelController.mainToPlayPanel();
			}
		});
	}
}
