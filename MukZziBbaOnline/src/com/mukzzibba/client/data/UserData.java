package com.mukzzibba.client.data;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;

public class UserData implements Serializable{
	private static final long serialVersionUID = 2607952590473208045L;
	
	public static boolean end=false;
	
	public static String serverIp="127.0.0.1";
	public static int port=5000;
	
	public static String nickname;	
	public static String password;
	public static boolean userCheck=true;		// false
	
	public static Socket mainSocket;
	public static InputStream is;
	public static OutputStream os;
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
}
