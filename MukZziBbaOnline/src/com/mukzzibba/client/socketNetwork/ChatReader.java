package com.mukzzibba.client.socketNetwork;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

import com.mukzzibba.client.data.UserData;

public class ChatReader extends Thread{
	private Socket sock;
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	String msg;
	String list;
	
	public ChatReader(){
		sock=UserData.chatSocket;
		try {
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(sock!=null && !sock.isClosed()) {
			try {
				msg=br.readLine();
				list=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			UserData.chat.append(msg);
			UserData.chat.append(System.lineSeparator());
			makeList(list);
			msg="";
		}
		UserData.chat.append("서버와 접속이 끊어졌습니다");
	}
	
	public static void makeList(String list){
		String[] split=list.split(" ");
		JTextArea area=UserData.chatList;
		
		area.setText("");
		for(int i=0; i<split.length; i++) {
			area.append(split[i]);
			area.append(System.lineSeparator());
		}
	}
}
