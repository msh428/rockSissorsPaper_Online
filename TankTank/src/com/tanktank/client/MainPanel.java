package com.tanktank.client;

import java.awt.GridLayout;
import java.awt.Panel;

public class MainPanel extends Panel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MainPanel(){
		this.setLayout(new GridLayout(1,1));
		StartPanel startPanel= new StartPanel();
		this.add(startPanel);
	}
}
