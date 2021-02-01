package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B9536 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
		    String[] animal = br.readLine().split(" ");

		    Map<String, String> cry = new HashMap<>();
		    String line;

		    while(!(line = br.readLine()).equals("what does the fox say?")) {
		    	String[] tmp = line.split(" ");
		    	cry.put(tmp[2], tmp[0]);
		    }
		      
		    for(String a : animal) {
		    	if(cry.get(a) == null) 
		    		sb.append(a).append(" ");
		    }
		    
		    sb.append("\n");
		}
		    
		System.out.println(sb);
	}

}
