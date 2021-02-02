package com.baek.recur.sil2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11729 {

	static int count, N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count=0;
		hanoi(N,1,2,3);
		sb.insert(0, count + "\n");
		System.out.println(sb);
	}
	
	public static void hanoi(int n, int from,int temp, int to) {
		if (n==1) {
			sb.append(from).append(" ").append(to).append("\n");
			count++;
			return;
		}
		
		hanoi(n-1,from, to, temp);
		sb.append(from).append(" ").append(to).append("\n");
		count++;
		hanoi(n-1,temp, from, to);
	}
}
