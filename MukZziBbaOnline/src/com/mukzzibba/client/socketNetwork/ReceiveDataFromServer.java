package com.mukzzibba.client.socketNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.mukzzibba.client.Panel.RankingPanel;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.server.data.ResultData;
import com.mukzzibba.server.userDb.UserInfo;

public class ReceiveDataFromServer {

	public static int intData(){
		int res=-1;
		InputStream is=null;
		
		try {
			is=UserData.mainSocket.getInputStream();
			res=is.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static String stringData(){
		String msg=null;
		
		InputStreamReader isr=null;
		BufferedReader br=null;
		isr=new InputStreamReader(UserData.is);
		br=new BufferedReader(isr);
		
		try {
			msg=br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return msg;
	}
	
	public static void userInfoData(){
		InputStream is=null;
		ObjectInput ois=null;
		UserInfo user=null;
		
		try {
			is=UserData.mainSocket.getInputStream();
			ois=new ObjectInputStream(is);
			
			user=(UserInfo)ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		UserData.me=user;
	}
	
	public static ResultData resultData(){
		InputStream is=null;
		ObjectInputStream ois=null;
		ResultData res=null;
		try {
			is = UserData.mainSocket.getInputStream();
			ois=new ObjectInputStream(is);
			
			res=(ResultData)ois.readObject();
		} catch (IOException e) {
			try {
				ois.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public static void rankInfo(){
		InputStream is=null;
		ObjectInput ois=null;
		ArrayList<UserInfo> list=null;
		UserInfo me=null;
		
		try {
			is=UserData.mainSocket.getInputStream();
			ois=new ObjectInputStream(is);
			
			list=(ArrayList<UserInfo>)ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		RankingPanel.list=new ArrayList<UserInfo>(list);
	}
}
