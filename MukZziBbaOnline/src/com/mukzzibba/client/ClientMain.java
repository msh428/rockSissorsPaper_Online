package com.mukzzibba.client;

import com.mukzzibba.client.window.ClientFrame;

public class ClientMain {

	public static void main(String[] args) {
		ClientFrame clientFrame=ClientFrame.getInstance();
		clientFrame.start();
	}
}
