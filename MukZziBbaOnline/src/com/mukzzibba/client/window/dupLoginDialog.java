package com.mukzzibba.client.window;

import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mukzzibba.client.socketNetwork.ChatManager;
import com.mukzzibba.client.socketNetwork.SendDataToServer;
import com.mukzzibba.client.socketNetwork.SignalToServer;

public class dupLoginDialog extends Dialog{
	
	Panel centerPanel;
	Panel southPanel;
	YesButton yes;
	NoButton no;
	
	public dupLoginDialog(){
		super(ClientFrame.getInstance(), "중복 로그인");
		
		setLayout(new GridLayout(2,1));
		centerPanel=new Panel(new GridLayout(2,1));
		southPanel=new Panel();
		
		Label msg1=new Label("중복 로그인이 감지되었습니다.");
		Label msg2=new Label("기존 연결을 끊고 접속하시겠습니까?");
		centerPanel.add(msg1);
		centerPanel.add(msg2);
		
		yes=new YesButton("네");
		no=new NoButton("아니오");
		
		southPanel.add(yes);
		southPanel.add(no);
		
		add(centerPanel);
		add(southPanel);
	}
	
	private class YesButton extends JButton{
		public YesButton(String msg){
			super(msg);
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SendDataToServer.intData(1);
					ChatManager.enterChatChannel();
				}
			});
		}
	}
	
	private class NoButton extends JButton{
		public NoButton(String msg){
			super(msg);
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SendDataToServer.intData(0);
				}
			});
		}
	}
}
