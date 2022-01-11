package com.mukzzibba.client.socketNetwork;

import com.mukzzibba.client.controller.PanelController;
import com.mukzzibba.client.data.UserData;


public class Login{

	public static void login(){
		SignalToServer.sendMsg("logi");		
		if(UserData.userChecked) {
			PanelController.mainToLobbyPanel();
		} else {
			
			System.out.println("로그인 정보가 잘못되었습니다");
		}
	}
	
	
	
}
