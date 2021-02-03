package com.baek.recur.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10994 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		recursive(n,0);
		System.out.println(sb);
	}
	
	static void recursive(int n, int en) {
		if(n==1) {
			for(int i=0;i<2*en+1;i++) 
				sb.append("* ");
			sb.append("\n");
			return;
		}
		for(int i=0;i<en;i++) 
			sb.append("* ");
		for(int i=0;i<4*n-3;i++) 
			sb.append("*");
		for(int i=0;i<en;i++) 
			sb.append(" *");
		sb.append("\n");
		for(int i=0;i<en+1;i++) 
			sb.append("* ");
		for(int i=0;i<4*n-7;i++) 
			sb.append(" ");
		for(int i=0;i<en+1;i++) 
			sb.append(" *");
		sb.append("\n");
		
		recursive(n-1,en+1);
		
		for(int i=0;i<en+1;i++) 
			sb.append("* ");
		for(int i=0;i<4*n-7;i++) 
			sb.append(" ");
		for(int i=0;i<en+1;i++) 
			sb.append(" *");
		sb.append("\n");
		for(int i=0;i<en;i++) 
			sb.append("* ");
		for(int i=0;i<4*n-3;i++) 
			sb.append("*");
		for(int i=0;i<en;i++) 
			sb.append(" *");
		sb.append("\n");
	}
}
