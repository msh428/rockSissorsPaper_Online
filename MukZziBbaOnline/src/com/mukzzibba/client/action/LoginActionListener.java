package com.mukzzibba.client.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mukzzibba.client.Panel.PanelController;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.socketNetwork.SignalToServer;

public class LoginActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SignalToServer.sendMsg("logi");
		if(UserData.userChecked==0){
			System.out.println("로그인 성공");
			PanelController.mainToLobbyPanel();
		} else if (UserData.userChecked==-1) {
			System.out.println("비번 틀림");
		} else if (UserData.userChecked==-2) {
			System.out.println("없는 아이디입니다");
		}
	}
	
}
