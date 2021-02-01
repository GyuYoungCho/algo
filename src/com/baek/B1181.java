package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		 
		String[] arr1 = new String[N];
 
		for (int i = 0; i < N; i++) {
			arr1[i] = br.readLine();
		}
		
		Arrays.sort(arr1, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}  
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		sb.append(arr1[0]).append('\n');
		
		for (int i = 1; i < N; i++) {
			
			if (!arr1[i].equals(arr1[i - 1])) {
				sb.append(arr1[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
}
