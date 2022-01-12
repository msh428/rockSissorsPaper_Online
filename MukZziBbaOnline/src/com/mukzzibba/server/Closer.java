package com.mukzzibba.server;

import java.io.IOException;
import java.net.Socket;
import java.util.stream.Stream;

public class Closer {
	
	public static void closeSocket(Socket sock) {
		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <E> void closeStream(Stream<E> stream){
		stream.close();
	}
}