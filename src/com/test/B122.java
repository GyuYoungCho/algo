package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B122 {
	static int N;
	static int [][] arr,dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

	    
		N = Integer.parseInt(br.readLine());
		arr = new int[N][4];
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		arr[N-1][0] = Integer.parseInt(st.nextToken());
		arr[N-1][1] = Integer.parseInt(st.nextToken());
		
		dp = new int[N][4];
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		for (int i = 1; i < N; i++) {
			
			dp[i][0] = dp[i-1][0] + arr[i][0];
			dp[i][1] = dp[i-1][1] +arr[i][1];
			dp[i][2] = dp[i-1][2] +arr[i][1] + arr[i][2];
			dp[i][3] = dp[i-1][3] +arr[i][0] + arr[i][2];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			min = Math.min(min, dp[N-1][i]);
		}
		System.out.println(min);
	}
	
}
