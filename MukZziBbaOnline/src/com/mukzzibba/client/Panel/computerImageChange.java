package com.mukzzibba.client.Panel;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.mukzzibba.client.data.UserData;

public class computerImageChange extends Thread {
	
	JLabel com;
	Random ran;
	int n;
	ImageIcon rock;
	ImageIcon scis;
	ImageIcon pape;
	
	public computerImageChange(){
		com=UserData.computer;
		ran=new Random();
		rock=new ImageIcon(".\\img\\ro.png");
		scis=new ImageIcon(".\\img\\si.png");
		pape=new ImageIcon(".\\img\\pa.png");
	}
	
	@Override
	public void run() {
		while(UserData.gameStart!=0){
			n=ran.nextInt(3);
			switch(n){
				case 0:
					com.setIcon(rock);
					break;
				case 1:
					com.setIcon(scis);
					break;
				case 2:
					com.setIcon(pape);
					break;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
