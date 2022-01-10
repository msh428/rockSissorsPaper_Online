package com.mukzzibba.client.controller;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

import com.mukzzibba.client.button.ButtonWithSendingMsg;
import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.ToLobbyButton;
import com.mukzzibba.client.window.ClientFrame;

public class PlayPanel extends Panel{
	Frame frame;
	Button me;
	Button com;
	ExitButton exit;
	ToLobbyButton toLobby;
	DrawPanel draw;
	
	public PlayPanel() {
		frame=ClientFrame.getInstance();
		me=new Button("나");
		com=new Button("컴");
		toLobby=new ToLobbyButton("뒤로");
		exit=new ExitButton("나가기", frame);
		draw=new DrawPanel();
		
		add(me);
		add(com);
		add(toLobby);
		add(exit);
		add(draw);
	}
}
