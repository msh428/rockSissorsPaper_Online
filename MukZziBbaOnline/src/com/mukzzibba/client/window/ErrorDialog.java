package com.mukzzibba.client.window;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.Window;

public class ErrorDialog extends Dialog{
	Label la;
	Button butn;
	
	public ErrorDialog(String msg, Window window) {
		super(window, "true");
	}
	
}