package com.example.core.tip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertFile {
	
	private static BufferedReader reader;
	private static String Folder = "C:\\Users\\ashok\\Desktop\\vuongtest\\map\\";
	public static void main(String arg[]){
		
		File file = new File(Folder);
		File[] files = file.listFiles();
		for(File item : files){
			processFile(item);
		}
	}
	
	private static void processFile(File file) {
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
			String line ="";
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			SimpleDateFormat dayFormat = new SimpleDateFormat("MM/dd/yyy");
			SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
			
			
			File writefile = new File(Folder + "new" + file.getName());
			if(!writefile.exists()){
				writefile.createNewFile();
			}
			
			FileWriter fw = new FileWriter(writefile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			int row =0;
			while((line = reader.readLine()) != null){
				if(row<3){
					row++;
					continue;
				}
				if(row==3){
					bw.write(line.replace("time", "Date,Time"));
					bw.newLine();
				}else{
				  String sdate = line.split(",")[0];
				  Date date = format.parse(sdate);
				  bw.append(dayFormat.format(date));
				  bw.append(",");
				  bw.append(hourFormat.format(date));
				  bw.append(line.replace(sdate, ""));
				  bw.newLine();
				}
				row++;
			
			}
			reader.close();
			fileReader.close();
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
