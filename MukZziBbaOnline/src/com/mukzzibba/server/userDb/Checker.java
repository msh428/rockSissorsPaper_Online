package com.mukzzibba.server.userDb;

import java.io.IOException;
import java.net.Socket;
import java.util.TreeMap;

import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.client.data.RegistData;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.server.ReceiveDataFromClient;
import com.mukzzibba.server.SendDataToClient;

public class Checker {
	
	public static void acceptLogin(Socket sock){
		String msg="";
		LoginData user=null;
		user=ReceiveDataFromClient.loginData(sock);
		String name=user.nickname.getText();
		String pass=user.password.getText();
		if(NicknameDB.isNameInDb(name)) {
			if(isPasswordMatchNickname(name,pass)){
				msg="�г��� ����� ��ġ�մϴ�";
				SendDataToClient.intData(sock, 0);
				SendDataToClient.userInfoData(sock,name);
				return ;
			} else {
				msg="��й�ȣ�� Ʋ�Ƚ��ϴ�";
				SendDataToClient.intData(sock, -1);
			}
		} else {
			msg="�г����� ã�� �� �����ϴ�";
			SendDataToClient.intData(sock, -2);
		}
	}
	
	public static void checkNickname(Socket sock){
		RegistData user=null;
		String name=null;
		
		user=Register.getRegistID(sock);
		name=user.nickname.getText();
		if(NicknameDB.isNameInDb(name)) {
			Register.sendMsgToClient("��� �Ұ���", sock);
		} else {
			Register.sendMsgToClient("��� �����մϴ�", sock);
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