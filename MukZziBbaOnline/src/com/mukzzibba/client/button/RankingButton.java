package com.mukzzibba.client.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.Panel.PanelController;

public class RankingButton extends ButtonWithSendingMsg{
	private static final long serialVersionUID = 1583382030264431514L;

	public RankingButton(String name) {
		super(name, "rank");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelController.mainToRankingPanel();
			}
		});
	}
}
