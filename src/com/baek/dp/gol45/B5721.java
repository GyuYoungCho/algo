package com.baek.dp.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5721 {
	static int N,M;
	static int arr[][], dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb =new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N==0) break;
			arr = new int [N+1][M+1];
			dp = new int [N+1][M+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i <= N; i++) {
				dp[i][1] = arr[i][1];
				for (int j = 2; j <= M; j++) {
					dp[i][j] = Math.max(dp[i][j-2]+arr[i][j], dp[i][j-1]);
				}
				
			}
				
			for (int i = 2; i <= N; i++) {
				dp[i][M] = Math.max(dp[i-2][M] + dp[i][M], dp[i-1][M]);
			}
			
			sb.append(dp[N][M]).append("\n");
		}
		System.out.println(sb);
	}

}
