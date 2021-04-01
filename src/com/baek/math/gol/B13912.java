package com.baek.math.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13912 {
	static final long R = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int h = Integer.parseInt(br.readLine());
		long[] dp = new long[11];
		long[][] arr = new long[2048][2048];
		
		arr[0][0] = 1;
		for(int i=1;i<2048;i++) {
			arr[i][0] = 1;
			for(int j=1;j<=i;j++) {
				arr[i][j] = (arr[i-1][j] + arr[i-1][j-1])%R;
			}
		}
		dp[0] = 1;
		for(int i=1;i<=h;i++) {
			dp[i] = (dp[i-1]*dp[i-1]) % R;
			dp[i] *= arr[(1<<(i+1))-2][(1<<i)-1];
			
			dp[i] %=R;
		}
		System.out.println(dp[h]);
	}

}

//1 23 -> 2

//1 
//25
//3467 -> 8

//1
//24
//3567 -> 8+8+8

//1
//23
//4567 -> 8+8+8+8+8+8
