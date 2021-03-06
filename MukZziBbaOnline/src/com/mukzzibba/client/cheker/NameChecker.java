package com.mukzzibba.client.cheker;

import com.mukzzibba.client.data.UserData;

public class NameChecker {
	
	public static boolean nicknameValidation(){
		if(numError() || hasEmpty()) {
			return false;
		}
		return true;
	}
	
	public static boolean numError() {
		String str=new String(UserData.regist.nickname.getText());

		if(str.length()<2 || str.length()>8){
			return true;
		}	
		return false;
	}
	
	public static boolean hasEmpty() {
		String str=new String(UserData.regist.nickname.getText());
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isWhitespace(str.charAt(i))){
				return true;
			}
		}
		return false;
	}
}
