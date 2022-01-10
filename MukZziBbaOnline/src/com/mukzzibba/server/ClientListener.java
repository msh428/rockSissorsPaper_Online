package com.mukzzibba.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.GregorianCalendar;

public class ClientListener extends Thread{
	Socket sock;
	InputStream is;
	OutputStream os;
	InputStreamReader isr;
	OutputStreamWriter osw;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	StreamOpener so;
	StreamOpener sc;
	
	String msg;
	int isNext;
	
	public ClientListener(Socket sock) {
		so=new StreamOpener();
		this.sock=sock;
		run();
	}
	
	@Override
	public void run() {
		is=so.OpeninputStream(sock);
		isr=so.OpeninputStreamReader(is);
		os=so.OpenoutputStream(sock);
		osw=so.OpenoutputStreamWriter(os);
		oos=so.OpenObjectOutputStream(os);
		ois=so.OpenObjectInputStream(is);
		
		while(true) {
			msg="";
			try {
				isNext=is.read();
				if(isNext!=-1){
					System.out.println("\n��� ����");
					msg=""+(char)isNext;
					for(int i=0; i<3; i++){
						msg+=(char)is.read();
					}
				}
				System.out.println("msg "+msg);
				
				if(IsBool.isGame(msg)){
					oos.writeObject(Calculator.getResult(msg));
				}
				
				if(msg.equals("exit")){ break; }
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("��� ��");
		StreamCloser.closeObjectInputStream(ois);
		StreamCloser.closeObjectOutputStream(oos);
		StreamCloser.closeInputStream(is);
		StreamCloser.closeInputStreamReader(isr);
		StreamCloser.closeOutputStream(os);
		StreamCloser.closeOutputStreamWriter(osw);
	}
}