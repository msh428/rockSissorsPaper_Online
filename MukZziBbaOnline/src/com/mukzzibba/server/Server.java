package com.mukzzibba.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static ServerSocket serv;
	public static ArrayList<Socket> socketList;
	Socket sock;
	InetAddress addr;
	
	public Server() {
		try {
			serv=new ServerSocket(5000);
			socketList=new ArrayList<Socket>();
			
			while(true) {
				try {
					sock=serv.accept();
					socketList.add(sock);
					addr=sock.getInetAddress();
					System.out.println(addr.getHostName()+" ���ӵ�");
					new ClientListener(sock);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serv.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
