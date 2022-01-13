package com.mukzzibba.server.userDb;

import java.net.Socket;

import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.client.data.RegistData;
import com.mukzzibba.server.ReceiveDataFromClient;
import com.mukzzibba.server.SendDataToClient;

public class Checker {
	
	public static void acceptLogin(Socket sock){
		LoginData user=null;
		user=ReceiveDataFromClient.loginData(sock);
		String name=user.nickname.getText();
		String pass=user.password.getText();
		if(NicknameDB.isNameInDb(name)) {
			if(isPasswordMatchNickname(name,pass)){
				SendDataToClient.intData(sock, 0);
				SendDataToClient.userInfoData(sock,name);
				return ;
			} else {
				SendDataToClient.intData(sock, -1);
			}
		} else {
			SendDataToClient.intData(sock, -2);
		}
	}
	
	public static void checkNickname(Socket sock){
		RegistData user=null;
		String name=null;
		
		user=Register.getRegistID(sock);
		name=user.nickname.getText();
		if(NicknameDB.isNameInDb(name)) {
			Register.sendMsgToClient("사용 불가능", sock);
		} else {
			Register.sendMsgToClient("사용 가능합니다", sock);
		}
	}
	
	public static boolean isPasswordMatchNickname(String name, String pass) {
		UserInfo user=null;
		user=UserDB.getUserFromFile(name);
		if(user==null){
			return false;
		}
		return true;
	}
	
}
