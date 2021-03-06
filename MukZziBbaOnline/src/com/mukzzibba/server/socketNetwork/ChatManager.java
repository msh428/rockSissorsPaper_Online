package com.mukzzibba.server.socketNetwork;

import java.net.Socket;

import com.mukzzibba.client.data.LoginData;

public class ChatManager {
	
	public static void userEnter(Socket sock){
		LoginData user;
		String name="";
		int clientWantChat;
		
		user=ReceiveDataFromClient.loginData(sock);
		name=user.nickname.getText();
		if(ChatWriter.isUserOnline(name)){
			SendDataToClient.intData(sock, 1);
		} else {
			SendDataToClient.intData(sock, 0);
		}
		clientWantChat=ReceiveDataFromClient.intData(sock);
		if(clientWantChat==0){
			return ;
		}
		ChatWriter.addOnlineUser(name, sock);
		Thread chat=new ChatReader(sock, name);
		chat.start();
	}
}
