package com.mukzzibba.server.userDb;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.mukzzibba.client.data.RegistData;

public class Register {
	
	public static void registerNewID(Socket sock){
		String name=null;
		String pass=null;
		RegistData newUser=null;
		
		newUser=getRegistID(sock);
		name=newUser.nickname.getText();
		pass=newUser.password.getText();
		registUserToDB(name, pass, sock);
	}
	
	public static void registUserToDB(String name, String pass, Socket sock){ 
		UserInfo userInfo=new UserInfo(name, pass);
		String msg="회원가입 성공";
		
		if(NicknameDB.isNameInDb(name)){
			msg="계정이 이미 존재합니다";
		} else {
			NicknameDB.addToDBFile(name);
		}
		UserDB.addToDBFile(userInfo);
		
		sendMsgToClient(msg, sock);	
	}
	
	public static void sendMsgToClient(String msg, Socket sock){
		OutputStreamWriter osr=null;
		BufferedWriter br=null;
		
		try {
			osr=new OutputStreamWriter(sock.getOutputStream());
			br=new BufferedWriter(osr);
			
			br.write(msg);
			br.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				osr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg+" (전송됨)");
	}
	
	public static RegistData getRegistID(Socket sock){
		RegistData res=null;
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(sock.getInputStream());
			res=(RegistData)ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
}
