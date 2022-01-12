package com.mukzzibba.server.userDb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.mukzzibba.server.ResultData;

public class UserDB {
	
	
	public static TreeMap<String,UserInfo> getDBfromFile(){
		TreeMap<String,UserInfo> db=null;
		File file=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		file=new File("UserDB");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			makeFirstDb(file);
		}
		
		try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			
			db=(TreeMap<String,UserInfo>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return db;
	}
	
	public void addToDBFile(UserInfo user){
		TreeMap<String,UserInfo> db=getDBfromFile();
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		File file;
		
		String key=new String(user.nickname);
		db.put(key, user);
		
		file=new File("UserDB");
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			
			oos.writeObject(db);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void makeFirstDb(File file){
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		TreeMap<String, UserInfo> empty=null;
		
		empty=new TreeMap<String, UserInfo>();
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			
			oos.writeObject(empty);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static UserInfo getUserFromFile(String name){
		TreeMap<String,UserInfo> db=null;
		db=getDBfromFile();
		UserInfo res=db.get(name);
		return res;
	}
	
	public void UpdateUserResultData(){
		
	}
}
