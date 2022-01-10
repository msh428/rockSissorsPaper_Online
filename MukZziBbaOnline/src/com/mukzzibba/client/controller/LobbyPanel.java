package com.mukzzibba.client.controller;

import java.awt.Frame;
import java.awt.Panel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.PlayButton;
import com.mukzzibba.client.button.RankingButton;
import com.mukzzibba.client.window.ClientFrame;

public class LobbyPanel extends Panel{
	Frame frame;
	PlayButton play;
	RankingButton rankboard;
	ExitButton exit;
	
	public LobbyPanel() {
		frame=ClientFrame.getInstance();
		
		play=new PlayButton("플레이");
		rankboard=new RankingButton("랭킹");
		exit=new ExitButton("나가기", frame);
		
		add(play);             
		add(rankboard);
		add(exit);
	}
}
