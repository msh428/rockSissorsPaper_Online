package com.mukzzibba.client.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.Panel.PanelController;
import com.mukzzibba.client.Panel.RankingPanel;
import com.mukzzibba.client.socketNetwork.SignalToServer;

public class RankingButton extends ButtonWithSendingMsg{
	private static final long serialVersionUID = 1583382030264431514L;

	public RankingButton(String name) {
		super(name);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignalToServer.sendMsg("rank");
				PanelController.onlyPanelChange(new RankingPanel());
			}
		});
	}
}
