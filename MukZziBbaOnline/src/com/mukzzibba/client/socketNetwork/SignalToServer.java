package com.mukzzibba.client.socketNetwork;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import com.mukzzibba.server.IsBool;
import com.mukzzibba.server.ResultData;
import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.server.ResultData;

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
			

			if (msg.equals("logi")) {
//				sendLoginInfo();
			} else if(IsBool.isGame(msg)){
//				getResultData();				
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
	

	
	public static void setLogin(){
		UserData.userChecked=true;
	}
}
