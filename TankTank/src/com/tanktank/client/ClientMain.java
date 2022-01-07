package com.tanktank.client;

import java.io.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientMain extends Frame{
	String serverIP;
	
	Panel mainPanel;
	Panel startPanel;
	Panel robbyPanel;
	Panel rankingBoardPanel;
	
	Button playButtonInRobby;
	Button rankingButtonInRobby;
	Button exitButtonInRobby;
	Button backButtonInRankingBoard;
	
	Socket sock;
	InputStream is;
	OutputStream os;

	ClientMain(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		mainPanel=new Panel();
		mainPanel.setLayout(new GridLayout(1,1));
		
		startPanel=new Panel();
		startPanel.setLayout(new BorderLayout());
		
		String nameOfGame="TankTank";
		
		String makerOfGame="maker : minsungho";
		String pleasePressMsg="please press";
		Panel downPanel=new Panel();
		downPanel.setLayout(new GridLayout(2,1));
		Label gameMakerLabel=new Label(makerOfGame);
		gameMakerLabel.setAlignment(Label.CENTER);
		Button pleasePressButton=new Button(pleasePressMsg);
		pleasePressButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enterGameRobby();
			}
		});
		downPanel.add(pleasePressButton);
		downPanel.add(gameMakerLabel);
		
		Label gameNameLabel=new Label(nameOfGame);
		gameNameLabel.setAlignment(Label.CENTER);
		
		startPanel.add(gameNameLabel, BorderLayout.CENTER);
		startPanel.add(downPanel, BorderLayout.SOUTH);
		
		mainPanel.add(startPanel);
		
		add(mainPanel);
		setBounds(100,100,500,500);
		setVisible(true);
		this.setResizable(false);
	}
	
	private void enterGameRobby(){
		
		Dialog inputServerDialog=new Dialog(this, false);
		inputServerDialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				inputServerDialog.dispose();
			}
		});
		Panel inputServerPanel=new Panel();
		inputServerDialog.setVisible(true);
		inputServerDialog.setBounds(100, 100, 300, 200);
		
		Label inputIpMsg=new Label("input server ip(default xxx.xxx.xxx.xxx)"); 
		inputServerPanel.add(inputIpMsg);
		TextField ip=new TextField(20);
		inputServerPanel.add(ip);
		Button confirmIp=new Button("confirm");
		confirmIp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ipConfirmed(ip.getText());					
				System.out.println(ip.getText());
				inputServerDialog.dispose();
			}
		});
		Button cancelIp=new Button("cancel");
		cancelIp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputServerDialog.dispose();
			}
		});
		inputServerPanel.add(confirmIp);
		inputServerPanel.add(cancelIp);
		
		inputServerDialog.add(inputServerPanel);			
		
		
		robbyPanel=new Panel();
		
		playButtonInRobby=new Button("play");
		playButtonInRobby.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterPlayGame();
			}
		});
		
		rankingButtonInRobby=new Button("ranking");
		rankingButtonInRobby.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					viewRankingBoard();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		exitButtonInRobby=new Button("exit");
		exitButtonInRobby.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		robbyPanel.add(playButtonInRobby);
		robbyPanel.add(rankingButtonInRobby);
		robbyPanel.add(exitButtonInRobby);
		
		// 소켓 열기


		
		mainPanel.removeAll();
		mainPanel.add(robbyPanel);
		this.revalidate();


		
	}
	
	public void ipConfirmed(String inputIp){
		if(serverIP==null){	// 이게 아니라 ip가 널이 아니면 창을 안열어야지...
			serverIP=inputIp;
			try {
				sock=new Socket(serverIP, 5000);	
				
//			sock.close();	// 클로즈를 종료할 때 해야 하나?
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}		
	}
	
	public void enterPlayGame(){
		mainPanel.removeAll();
		
		mainPanel.add(new Button("playing game display"));
		mainPanel.revalidate();
		
	}
	
	public void viewRankingBoard() throws UnknownHostException, IOException{
		
		rankingBoardPanel=new Panel();
		rankingBoardPanel.setLayout(new BorderLayout());
		Label rankingBoardLabel=new Label("Ranking Board");
		Panel specInRankingPanel=new Panel();
		backButtonInRankingBoard=new Button("back_in_rankingBoard");
		
		specInRankingPanel.setLayout(new GridLayout(10,6));
		Label[] rankingLa=new Label[60];
		rankingLa[0]=new Label("rank");
		rankingLa[1]=new Label("nickname");
		rankingLa[2]=new Label("score");
		rankingLa[3]=new Label("win ratio");
		rankingLa[4]=new Label("wins");
		rankingLa[5]=new Label("loses");
		
		for(int i=6; i<60; i++){
			if(i%6==0){
				rankingLa[i]=new Label(""+(i-5));
			}else if(i%6==1){
				rankingLa[i]=new Label("name"+(i-5));
			}else if(i%6==2){
				rankingLa[i]=new Label(""+i);
			}else if(i%6==3){
				rankingLa[i]=new Label(""+i+"%");
			}else if(i%6==4){
				rankingLa[i]=new Label(""+(i+10));
			}else if(i%6==5){
				rankingLa[i]=new Label(""+(i+7));
			}
		}
		for(int i=0; i<60; i++){
			specInRankingPanel.add(rankingLa[i]);
		}
		
		backButtonInRankingBoard.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				enterGameRobby();
			}
		});
		
		rankingBoardPanel.add(rankingBoardLabel, BorderLayout.NORTH);
		rankingBoardPanel.add(specInRankingPanel, BorderLayout.CENTER);
		rankingBoardPanel.add(backButtonInRankingBoard, BorderLayout.SOUTH);

		mainPanel.removeAll();
		mainPanel.add(rankingBoardPanel);
		this.revalidate();
	}
	
	public static void main(String[] args) {
		ClientMain newGame=new ClientMain();
	}
	
}
