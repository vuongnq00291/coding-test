package com.example.core.tip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ConvertFileMeasureHeader {
	
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
			File writefile = new File(Folder + "newheader" + file.getName());
			if(!writefile.exists()){
				writefile.createNewFile();
			}
			
			FileWriter fw = new FileWriter(writefile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			while((line = reader.readLine()) != null){
				String header[] = line.split(",");
				for(int i=2;i<header.length;i++){
					String measure = header[i].split("\\(")[0];
					String unit = header[i].split("\\(")[1].replace("(", "").replace(")", "");
					bw.append("2");
					bw.append(",");
					bw.append(header[i]);
					bw.append(",");
					bw.append(measure);
					bw.append(":");
					bw.append(unit);
					bw.newLine();
				}
				break;
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
