package com.mukzzibba.server.userDb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class NicknameDB {
	
	@SuppressWarnings("unchecked")
	public static HashSet<String> getDBfromFile(){
		HashSet<String> res=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		File file;
		
		file=new File("NicknameDB");
		if(!file.exists()){
			try {
				file.createNewFile();
				makeFirstDb(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			
			res=(HashSet<String>)ois.readObject();
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
		
		return res;
	}
	
	public static boolean isNameInDb(String name){
		HashSet<String> db=getDBfromFile();
		
		if(db.contains(name)){
			return true;
		}
		return false;
	}
	
	public static void addToDBFile(String name){
		File file;
		HashSet<String> db;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
		db=getDBfromFile();
		db.add(name);
		
		file=new File("NicknameDB");
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
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void makeFirstDb(File file){
		FileOutputStream fos = null;
		ObjectOutputStream oos=null;
		Set<String> empty=new HashSet<String>();
		
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
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
