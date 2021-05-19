package com.baek.math.gol;

import java.io.*;
import java.util.*;

public class B12886 {
	static int A,B,C,total;
	static boolean[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		total = A+B+C;
		if(total%3!=0) {
			System.out.println(0);return;
		}
		memo = new boolean[total+1][total+1];
		find(A,B);
		System.out.println(memo[total/3][total/3]?1:0);
	}
	
	private static void find(int a, int b) {
		if(memo[a][b]) {return ;}
		
		memo[a][b] = true;
		
		int c = total - a - b;
		if(a != b) {
			if(a > b) find(a-b, b+b);
			else find(a+a, b-a);
		}
		
//		if(a != c) {
			if(a > c) find(a-c, c+c);
			else find(a+a, c-a);
//		}
		
		if(c != b) {
			if(c > b) find(c-b, b+b);
			else find(c+c, b-c);
		}
	}
}
