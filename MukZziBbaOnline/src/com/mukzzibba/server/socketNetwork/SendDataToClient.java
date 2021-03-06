package com.mukzzibba.server.socketNetwork;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.mukzzibba.server.data.ResultData;
import com.mukzzibba.server.userDb.UserDB;
import com.mukzzibba.server.userDb.UserInfo;

public class SendDataToClient {
	
	public static void resultData(ResultData data, Socket sock){
		ObjectOutputStream oos=null;
		
		try {
			oos=new ObjectOutputStream(sock.getOutputStream());
			oos.writeObject(data);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void userInfoData(Socket sock,String name){
		OutputStream os=null;
		ObjectOutputStream oos=null;
		
		try {
			os=sock.getOutputStream();
			oos=new ObjectOutputStream(os);
			
			oos.writeObject(UserDB.getUserFromFile(name));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void intData(Socket sock, int returnCode){
		OutputStream os=null;
		
		try {
			os=sock.getOutputStream();
			os.write(returnCode);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void rankInfo(Socket sock, ArrayList<UserInfo> list){
		OutputStream os=null;
		ObjectOutputStream oos=null;
		
		try {
			os=sock.getOutputStream();
			oos=new ObjectOutputStream(os);
			
			oos.writeObject(list);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
