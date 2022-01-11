package com.mukzzibba.server.userDb;

import java.io.IOException;
import java.io.ObjectInputStream;

import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.server.*;

public class UserChecker {
	
	
	public static void CheckUserData(ObjectInputStream ois) {
		LoginData input;
		boolean isName,isPass;
		
		input=UserDataRead(ois);
		isName=checkNickname(input.nickname.getText());
		isPass=checkPassword(input.password.getText());
	}
	
	public static boolean checkNickname(String nickname){
		System.out.println(nickname);
		return true;
	}
	
	public static boolean checkPassword(String password){
		System.out.println(password);
		return true;
	}
	
	public static LoginData UserDataRead(ObjectInputStream ois) {
		LoginData input=null;
		
		try {
			input = (LoginData)ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
}
