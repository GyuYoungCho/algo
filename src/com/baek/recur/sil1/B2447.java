package com.baek.recur.sil1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2447 {
	static StringBuilder sb = new StringBuilder();
	static char [][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(arr[i],' ');
		}
		
		recursive(0,0,n);
		
		for(char[] ar : arr) {
			for(char a : ar) {
				sb.append(a);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void recursive(int a, int b, int n) {
		int div = 0;
		if(n==1) { 
			arr[a][b] = '*';
			return;
		}
		
		 div= n/3; 
		
		for(int i=0;i<3;i++) { 
			for(int j=0;j<3;j++) {
				if(i==2 && j ==1) continue;
				recursive(a+(div*i),b+(div*j),div);
			}
		}
	}
}
