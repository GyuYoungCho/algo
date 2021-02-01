package com.saffy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class strc {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
 
		e:for (int k = 0; k < N; k++) {		 // string tokenizer
			String str = br.readLine();
			int target = str.indexOf(" ");
		    String s1 = str.substring(0,target);
		    String s2 = str.substring(target + 1);
		    
		    int [] arr1 = new int[26];
			int [] arr2 = new int[26];
			
			for(int i=0;i<s1.length();i++)
				arr1[s1.charAt(i) - 'a']++;
			for(int i=0;i<s2.length();i++)
				arr2[s2.charAt(i) - 'a']++;
			for(int i=0;i< 26;i++)
				if (arr1[i] - arr2[i] != 0) {
					sb.append("Impossible"+"\n");
					continue e;
				}
			sb.append("Possible"+"\n");
		}
		
		br.close();
		System.out.print(sb);
	}

}
