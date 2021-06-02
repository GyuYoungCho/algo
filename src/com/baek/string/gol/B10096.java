package com.baek.string.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10096 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		if(N%2==0) {
			System.out.println("NOT POSSIBLE");
			return;
		}
		int[] cnt = new int[26];
		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			cnt[str.charAt(i)-'A']++;
		}
		char sel = '0';
		for (int i = 0; i < 26; i++) {
			if(cnt[i]%2==1) sel = (char)(i+65);
		}
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i)==sel ) {
				
			}
		}
		
		
	}

}
