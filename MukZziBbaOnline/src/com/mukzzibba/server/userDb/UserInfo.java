package com.mukzzibba.server.userDb;

import java.io.Serializable;

public class UserInfo implements Serializable{
	private static final long serialVersionUID = -3534762134651827696L;
	
	public String nickname;
	public String password;
	public int win;
	public int lose;
	public double winRatio;
	public int rank;
	
	public UserInfo(String name, String pass){
		nickname=name;
		password=pass;
		win=0;
		lose=0;
		winRatio=0.0;
		rank=-1;
	}
}