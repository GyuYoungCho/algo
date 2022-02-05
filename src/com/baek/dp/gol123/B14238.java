package com.baek.dp.gol123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14238 {
	static boolean[][][][][] dp;
	static int[] abc = new int[3];
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char arr[] = br.readLine().toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='A') abc[0]++;
			else if(arr[i]=='B') abc[1]++;
			else abc[2]++;
		}
		
		dp = new boolean[abc[0]+1][abc[1]+1][abc[2]+1][3][3];
		search(abc[0],abc[1],abc[2],0,0, new String(""));
		
		if(!flag) System.out.println(-1);
	}
	
	private static void search(int a, int b, int c, int i, int j, String str) {
		if(flag) return;
		
		if(a==0&&b==0&&c==0) {
			System.out.println(str);
			flag = true;
			return;
		}
		
		if(dp[a][b][c][i][j]) return;
		dp[a][b][c][i][j] = true;
		
		if(c>0&&i!=2 &&j!=2 ) search(a,b,c-1,j,2,str+"C");
		if(b>0&&j!=1 ) search(a,b-1,c,j,1,str + "B");
		if(a>0) search(a-1,b,c,j,0,str + "A");
		
		
	}

}
