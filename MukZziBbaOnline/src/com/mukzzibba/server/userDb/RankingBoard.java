package com.mukzzibba.server.userDb;

import java.net.Socket;
import java.util.ArrayList;
import java.util.TreeMap;

import com.mukzzibba.client.data.LoginData;
import com.mukzzibba.server.socketNetwork.ReceiveDataFromClient;
import com.mukzzibba.server.socketNetwork.SendDataToClient;
import com.mukzzibba.util.RankingComparator;


public class RankingBoard {
	
	public static void getRank(Socket sock){	
		TreeMap<String, UserInfo> db=null;
		ArrayList<UserInfo> rankList=null;
		int userRank=0;
		
		db=UserDB.readDBfromFile();
		ArrayList<UserInfo> list=new ArrayList<>(db.values());
		list.sort(new RankingComparator());
		
		rankList=new ArrayList<>();
		int num=10;
		if(db.size() < 10) {
			num=db.size();
		}
		for(int i=0; i<num; i++) {
			rankList.add(list.get(i));
		}
		LoginData user=ReceiveDataFromClient.loginData(sock);
		SendDataToClient.rankInfo(sock, rankList);
		for(int i=0; i<num; i++){
			if(list.get(i).nickname.equals(user.nickname.getText())){
				userRank=i+1;
				break;
			}
		}
		SendDataToClient.intData(sock, userRank);
	}
}
