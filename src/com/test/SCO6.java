package com.test;

import java.io.*;
import java.util.*;

class SCO6 {
	static int N, M;
	static int[][] arr, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = Math.max(dp[i-1][j] ,dp[i][j-1]) + arr[i][j];
			}
		}
		System.out.println(dp[N][M]);
	}
}
