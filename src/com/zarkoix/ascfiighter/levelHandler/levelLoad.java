package com.zarkoix.ascfiighter.levelHandler;

import java.io.IOException;
import java.util.List;

public class levelLoad {
	public static List<String> getLevel(String loc) throws IOException{
		ReadWriteTextFileJDK7 text = new ReadWriteTextFileJDK7(); 
		List<String> lines = text.readSmallTextFile(loc);
		System.out.println(lines.size());
		if(lines.size() == 24){
			System.out.println("WE DONE WELL");
			return lines;
		}else return null;}
	}
	
	

	

