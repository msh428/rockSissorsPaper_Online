package com.mukzzibba.client.data;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;

import com.mukzzibba.server.ResultData;
import com.mukzzibba.server.userDb.UserInfo;

public class UserData implements Serializable{
	private static final long serialVersionUID = 2607952590473208045L;
	
	public static boolean end=false;
	
	public static String serverIp="192.168.0.80";
	public static int port=5000;
	public static int userChecked;
	
	public static Socket mainSocket;
	public static InputStream is;
	public static OutputStream os;
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
	public static UserInfo me;
	
	transient public static ResultData result;
	transient public static LoginData login;
	transient public static RegistData regist;
}
