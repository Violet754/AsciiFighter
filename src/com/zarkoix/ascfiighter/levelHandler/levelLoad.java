package com.zarkoix.ascfiighter.levelHandler;

import java.io.IOException;
import java.util.List;

public class levelLoad {
	public static List<String> getLevel(String loc) throws IOException{
		ReadWriteTextFileJDK7 text = new ReadWriteTextFileJDK7(); 
		List<String> lines = text.readSmallTextFile(loc);
		
		return lines;
	}
	
}

	

