package com.mukzzibba.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.mukzzibba.client.data.LoginData;

public class ReceiveDataFromClient {
	
	public static LoginData loginData(Socket sock){
		InputStream is=null;
		ObjectInputStream ois=null;
		LoginData res=null;
		
		try {
			is=sock.getInputStream();
			ois=new ObjectInputStream(is);
			
			res=(LoginData)ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
}
