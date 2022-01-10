package com.mukzzibba.client.socketNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mukzzibba.client.data.UserData;

public class StreamOpener {
	
	public static void openInStream(){
		try {
			UserData.is=UserData.mainSocket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openOutStream(){
		try {
			UserData.os=UserData.mainSocket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openObjectInputStream(){
		try {
			UserData.ois=new ObjectInputStream(UserData.is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void openObjectOutputStream(){
		try {
			UserData.oos=new ObjectOutputStream(UserData.os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
