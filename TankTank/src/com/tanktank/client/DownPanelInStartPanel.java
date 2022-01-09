package com.tanktank.client;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DownPanelInStartPanel extends Panel{
	
	DownPanelInStartPanel(){
		this.setLayout(new GridLayout(2,1));
		String makerOfGame="maker : minsungho";
		Label gameMakerLabel=new Label(makerOfGame);
		gameMakerLabel.setAlignment(Label.CENTER);

		String pleasePressMsg="please press";
		Button pleasePressButton=new Button(pleasePressMsg);
		pleasePressButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClientWindow.enterGameRobby();
			}
		});
		this.add(pleasePressButton);
		this.add(gameMakerLabel);
		
		
	}
	
}
