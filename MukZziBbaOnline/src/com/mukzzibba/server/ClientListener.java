package com.mukzzibba.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.mukzzibba.server.userDb.SignalController;
import com.mukzzibba.util.Closer;

public class ClientListener extends Thread{
	Socket sock;
	String msg;
	final int msgNum;
	char[] charArr;
	int isNext;
	
	public ClientListener(Socket sock) {
		this.sock=sock;
		msgNum=4;
		charArr=new char[msgNum];
	} 
	
	@Override
	public void run() {
		msg=msgFromClient(sock);
		SignalController.SendResultToClient(msg, sock);
		if(!msg.equals("chat")){			
			Closer.closeSocket(sock);
		}
	}
	
	private String msgFromClient(Socket sock) {
		InputStream is=null;
		String msg=new String("");
		int num=-1;
			
		try {
			is=sock.getInputStream();
			num=is.read();
			if(num!=-1){				
				msg+=(char)num;
			}
			for(int i=0; i<msgNum-1; i++){
				num=is.read();
				msg+=(char)num;
			}
			System.out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}
	

}
