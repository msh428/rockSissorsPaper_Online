package com.mukzzibba.client.Panel;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import com.mukzzibba.client.button.ExitButton;
import com.mukzzibba.client.button.PlayButton;
import com.mukzzibba.client.button.RankingButton;
import com.mukzzibba.client.button.ToStartPanelButton;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.window.ClientFrame;

public class LobbyPanel extends Panel{
	private static final long serialVersionUID = -2473225825755910282L;
	
	Frame frame;
	PlayButton play;
	RankingButton rankboard;
	ToStartPanelButton toStart;
	ExitButton exit;
	Panel infoPanel;
	Label infoLabel;
	
	public LobbyPanel() {
		frame=ClientFrame.getInstance();
		
		infoPanel=new Panel();
		infoLabel=new Label();
		infoLabel.setText(UserData.me.nickname+" 점수"+UserData.me.score+" "+"게임 횟수 :"+UserData.me.playNum+" "+UserData.me.win+" "+UserData.me.lose+" "+UserData.me.winRatio);
		infoPanel.add(infoLabel);
		
		play=new PlayButton("플레이");
		rankboard=new RankingButton("랭킹");
		toStart=new ToStartPanelButton("뒤로");
		exit=new ExitButton("나가기", frame);
		
		add(infoPanel);
		add(play);             
		add(rankboard);
		add(toStart);
		add(exit);
	}
}
