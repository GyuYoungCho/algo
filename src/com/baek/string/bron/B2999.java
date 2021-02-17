package com.baek.string.bron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int len = s.length();
		int r = (int)Math.sqrt(len);
		while(len%r!=0) {
			r--;
		}
		int c = len/r;
		char[][] arr = new char[r][c];
		int idx = 0;
		
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				arr[j][i] = s.charAt(idx++);
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				sb.append(arr[i][j]);
			}
		}
		System.out.println(sb);
	}

}
