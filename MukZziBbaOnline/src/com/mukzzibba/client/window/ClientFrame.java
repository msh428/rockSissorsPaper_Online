package com.mukzzibba.client.window;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.activation.DataContentHandler;

import com.mukzzibba.client.controller.PanelController;
import com.mukzzibba.client.data.PanelData;
import com.mukzzibba.client.data.UserData;
import com.mukzzibba.client.socketNetwork.SignalToServer;

public class ClientFrame extends Frame {
	private static ClientFrame singleTone;
	
	private ClientFrame() {
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				singleTone.dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				UserData.end=true;
				try {
					UserData.mainSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	
	}
	
	public static ClientFrame getInstance() {
		if (singleTone==null) {			
			singleTone=new ClientFrame();
		}
		return singleTone;
	}
	
	public void frameStart() {
		new PanelController();
		
		add(PanelData.mainPanel);
		setBounds(100,100,500,500);
		setVisible(true);
	}
}
