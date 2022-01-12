package com.mukzzibba.client.Panel;

import java.awt.GridLayout;
import java.awt.Panel;

import com.mukzzibba.client.data.PanelData;

public class PanelController {
	
	public PanelController() {
		makePanels();
		mainToStartPanel();
	}
	
	public static void makePanels(){
		PanelData.mainPanel=new MainPanel();
		PanelData.startPanel=new StartPanel();
		PanelData.playPanel=new PlayPanel();
		PanelData.rankingPanel=new RankingPanel();
	}
	
	public static void mainToStartPanel(){
		PanelData.mainPanel.removeAll();
		PanelData.mainPanel.add(PanelData.startPanel);
		PanelData.mainPanel.revalidate();
	}
	
	public static void mainToLobbyPanel() {
		PanelData.mainPanel.removeAll();
		PanelData.mainPanel.add(PanelData.robbyPanel);
		PanelData.mainPanel.revalidate();
	}
	
	public static void mainToRankingPanel() {
		PanelData.mainPanel.removeAll();
		PanelData.mainPanel.add(PanelData.rankingPanel);
		PanelData.mainPanel.revalidate();
	}
	
	public static void mainToPlayPanel() {
		PanelData.mainPanel.removeAll();
		PanelData.mainPanel.add(PanelData.playPanel);
		PanelData.mainPanel.revalidate();
	}
}
