package com.baek.string.gol;

import java.io.*;
import java.util.*;

public class B17255 {
	static boolean visit[];
	static String s;
	static Set<String> all = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			String t = s.substring(i, i+1);
			dfs(t, i, i+1);
		}
		
		System.out.println(all.size());
	}
	
	static void dfs(String result, int st, int end){
	    if(st==0 && end==s.length()){
	        all.add(result);
	        
	        return;
	    }
	    
	    
	    if(st!=0) dfs(result + s.substring(st-1, end),st-1,end);
	    if(end!=s.length()) dfs(result + s.substring(st, end+1), st, end+1);
	}
}
