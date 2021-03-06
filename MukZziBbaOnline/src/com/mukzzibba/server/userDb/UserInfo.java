package com.mukzzibba.server.userDb;

import java.io.Serializable;

public class UserInfo implements Serializable, Comparable<UserInfo>{
	private static final long serialVersionUID = -3534762134651827696L;
	
	public String nickname;
	public String password;
	public int score;
	public int win;
	public int lose;
	public int draw;
	public int playNum;
	public double winRatio;
	public int rank;
	
	public UserInfo(String name, String pass){
		nickname=new String(name);
		password=new String(pass);
		playNum=0;
		score=0;
		win=0;
		lose=0;
		draw=0;
		winRatio=0.0;
		rank=-1;
	}
	
	public void updateResult(String result){
		if(result.equals("win")) {
			this.win++;
			this.score+=10;
		} else if (result.equals("lose")) {
			this.lose++;
			this.score-=8;
		} else if (result.equals("draw")){
			this.draw++;
			this.score+=3;
		}
		this.playNum++;
		if(playNum==0) {
			winRatio=0;
		} else {
			winRatio=(int)((win*10000/playNum))/100.0;
		}
		rank=UserDB.returnRank(nickname);
		System.out.println("서버에 갱신된 랭크는 "+rank);
	}

	@Override
	public int compareTo(UserInfo o) {
		return (o.score - this.score);
	}
	
}
