package com.mukzzibba.server.game;

import java.net.Socket;
import java.util.Random;

import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.server.data.ResultData;
import com.mukzzibba.server.socketNetwork.ReceiveDataFromClient;
import com.mukzzibba.server.socketNetwork.SendDataToClient;
import com.mukzzibba.server.userDb.UserDB;



public class Calculator {
	
	private Calculator() {}
	
	public static void sendResult(String msg, Socket sock){
		LoginData user=null;
		String name=null;
		ResultData resData=null;
		
		user=ReceiveDataFromClient.loginData(sock);
		name=user.nickname.getText();
		
		resData=getResultData(msg);
		
		UserDB.updateSingleUser(name, resData.result);
		SendDataToClient.resultData(resData,sock);
		
	}
	
	private static ResultData getResultData(String msg){
		ResultData res=new ResultData();
		
		res.userInt=getIntFromStr(msg);
		res.userStr=new String(msg);
		res.comInt=getRanNum();
		res.comStr=getStrFromInt(res.comInt);
		res.result=getResult(res.userInt, res.comInt);
		
		return res;
	}
	
	private static int getRanNum(){
		Random ran=new Random();
		
		int comInt=ran.nextInt(3);
		return comInt;
	}
	
	private static int getIntFromStr(String msg){
		int userInt;
		
		if(msg.equals("scis")){
			userInt=0;
		} else if(msg.equals("rock")){
			userInt=1;
		} else {
			userInt=2;
		}
		return userInt;
	}
	
	private static String getStrFromInt(int n){
		if(n==0){
			return new String("scis");
		} else if (n==1){
			return new String("rock");
		} else {
			return new String("pape");
		}
	}
	
	private static String getResult(int user, int com){
		if (user==com){
			return new String("draw");
		} else if (user-com==-2 || user-com==1){
			return new String("win");
		} else {
			return new String("lose");
		}
	}
}
