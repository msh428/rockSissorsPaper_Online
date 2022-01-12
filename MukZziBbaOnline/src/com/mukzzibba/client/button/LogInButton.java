package com.mukzzibba.client.button;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.Panel.LobbyPanel;
import com.mukzzibba.client.Panel.PanelController;
import com.mukzzibba.client.data.PanelData;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.socketNetwork.SignalToServer;

public class LogInButton extends Button{
	
	public LogInButton(String name) {
		setLabel(name);
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignalToServer.sendMsg("logi");
				if(UserData.userChecked==0){
					System.out.println("로그인 성공");
					PanelData.robbyPanel=new LobbyPanel();
					PanelController.mainToLobbyPanel();
				} else if (UserData.userChecked==-1) {
					System.out.println("비번 틀림");
				} else if (UserData.userChecked==-2) {
					System.out.println("없는 아이디입니다");
				}
			}
		});
	}
}
