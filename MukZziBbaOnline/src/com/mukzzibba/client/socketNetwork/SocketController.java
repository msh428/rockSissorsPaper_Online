package com.mukzzibba.client.socketNetwork;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.mukzzibba.client.data.UserData;

public class SocketController {
	
	public static void OpenSocket() {
		try {
			UserData.mainSocket=new Socket(UserData.serverIp, UserData.port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void CloseSocket() {
		try {
			UserData.mainSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openChatSocket(){
		UserData.chatSocket=UserData.mainSocket;
	}
}
