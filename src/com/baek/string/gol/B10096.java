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
		char[] str = br.readLine().toCharArray();
		for(char s:str) {
			cnt[s-'A']++;
		}
		char ans='0';
		
		
	}

}
