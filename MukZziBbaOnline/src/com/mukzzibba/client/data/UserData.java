package com.mukzzibba.client.data;

import java.awt.TextArea;
import java.awt.TextField;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mukzzibba.server.data.ResultData;
import com.mukzzibba.server.userDb.UserInfo;

public class UserData implements Serializable{
	private static final long serialVersionUID = 2607952590473208045L;
	
	public static boolean end=false;
	
	public static String serverIp="127.0.0.1";
	public static int port=5000;
	public static int userChecked;
	
	public static Socket mainSocket;
	public static Socket chatSocket;
	public static InputStream is;
	public static OutputStream os;
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
	public static UserInfo me;
	
	transient public static ResultData result;
	transient public static LoginData login;
	transient public static RegistData regist;

	transient public static int isChat;
	transient public static JTextArea chatList;
	transient public static TextArea chat;
	transient public static JTextField toWrite;
	
	transient public static int gameStart;
	transient public static JLabel computer;
}
