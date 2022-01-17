package com.mukzzibba.client.socketNetwork;

import java.io.IOException;

import com.mukzzibba.client.data.UserData;

public class StreamCloser {
		
	public static void closeInStream(){
		try {
			UserData.is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void closeOutStream(){
		try {
			UserData.os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
