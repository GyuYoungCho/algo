package com.baek.dp.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17498 {
	static int N, M, D;
	static long min = Long.MIN_VALUE, max = Long.MIN_VALUE;
	static long[][] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new long[N][M];
		dp = new long[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			Arrays.fill(dp[i], min);
		}
		for(int i=0;i<M;i++)
			dfs(0,i);
		
		System.out.println(max);
	}
	private static void dfs(int r, int c) {
		if(r==N-1) {
			max = Math.max(min, dp[r][c]);
			System.out.println("hi");
			return;
			
		}
		
		for (int i = r+1; i <= r+D; i++) {
			for (int j = c-D; j <= c+D; j++) {
				if(i<0||j<0||i>=N||j>=M) continue;
				if(dp[r][i]!=0) return;

				if(Math.abs(r-i) + Math.abs(c-j) <= D) {
					dfs(i,j);
					dp[i][j] = Math.max(dp[i][j],dp[i][j] + arr[r][c]*arr[i][j]);
				}
			}
		}
	}

}
