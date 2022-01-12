package com.mukzzibba.client.socketNetwork;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import com.mukzzibba.server.Calculator;
import com.mukzzibba.server.ResultData;
import com.mukzzibba.client.data.ClientSetter;
import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.server.ResultData;
import com.mukzzibba.server.userDb.Checker;
import com.mukzzibba.server.userDb.RankingBoard;
import com.mukzzibba.server.userDb.Register;
import com.mukzzibba.util.IsBool;

public class SignalToServer {
	
	public static void sendMsg(String msg) {
		OpenAndCloseSocket.OpenSocket();
		StreamOpener.openOutStream();
		StreamOpener.openInStream();
		
			try {
				UserData.os.write(msg.getBytes());
				UserData.os.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(msg.equals("logi")){
				SendDataToServer.loginData();
				UserData.userChecked=ReceiveDataFromServer.intData();
				if(UserData.userChecked==0){
					ReceiveDataFromServer.userInfoData();					
				}
			} else if(msg.equals("dupC")) {
				SendDataToServer.registData();
				ReceiveDataFromServer.stringData();
			} else if (msg.equals("regi")) {
				SendDataToServer.registData();
				ReceiveDataFromServer.stringData();
			} else if (msg.equals("rank")) {
				ReceiveDataFromServer.rankingData();
			} else if (IsBool.isGame(msg)) {
				SendDataToServer.loginData();
				ResultData res=null;
				res=ReceiveDataFromServer.resultData();
				ClientSetter.setResultData(res);
			} else {
				System.out.println("�Է��� �߸���");
			}
		
		StreamCloser.closeInStream();
		StreamCloser.closeOutStream();
		OpenAndCloseSocket.CloseSocket();
	}
	
	public static void sendLoginInfo() {
		StreamOpener.openObjectOutputStream();
		try {
			UserData.oos.writeObject(UserData.login);
			UserData.oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StreamCloser.closeObjectOutputStream();
	}
	
	public static void getResultData(){
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(UserData.is);
			UserData.result=(ResultData)UserData.ois.readObject();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	
	public static void setLogin(int isLogin){
		UserData.userChecked=isLogin;
	}
}
