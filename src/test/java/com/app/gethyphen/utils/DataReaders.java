package com.app.gethyphen.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.DataProvider;

//import org.testng.annotations.Test;

public class DataReaders {
	
	@DataProvider (name="PollTypes")
	public static Object[][] pollData() {
		
		String path = System.getProperty("user.dir") + "\\testData\\pollType";
		
		File fl = new File(path);
		List<String> pollType = new ArrayList<String>();
		
		try {
			
			Scanner read = new Scanner(fl);
			read.useDelimiter(",");
			
			while(read.hasNext()) {
				pollType.add(read.nextLine());
			}
			read.close();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//create an Object of 1 coloumn and Row of size of data
		Object[][] data = new Object[pollType.size()][4];

		for(int i=0;i<data.length;i++) {
			//String s = pollType.get(i);
			
			data[i] = pollType.get(i).split(",");
			//System.out.println(data[i][3]);
		}
		
		return data;
		/*
		 * for(String s : pollType) { System.out.println(s.toString()); }
		 */
	}

}
