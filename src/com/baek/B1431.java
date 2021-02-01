package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1431 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		 
		String[] arr1 = new String[N];
 
		for (int i = 0; i < N; i++) {
			arr1[i] = br.readLine();
		}
		Arrays.sort(arr1, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					int s1sum = 0;
					int s2sum = 0;
					for(int i=0;i<s1.length();i++) {
						if (s1.charAt(i) > 47 && s1.charAt(i) < 58) 
							s1sum+= s1.charAt(i);
						if (s2.charAt(i) > 47 && s2.charAt(i) < 58)
							s2sum+=s2.charAt(i);
					}
					if(s1sum == s2sum)
						return s1.compareTo(s2);
					else
						return s1sum - s2sum;
				}  
				else {
					return s1.length() - s2.length();
				}
			}
		});
		for (int i = 0; i < N; i++) {
			sb.append(arr1[i]).append('\n');
		}
		System.out.println(sb);
	}
}
