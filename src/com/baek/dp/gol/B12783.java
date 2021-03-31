package com.baek.dp.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12783 {
	static int T, N,M,K, min;
	static int[] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[1000001];
			
			M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				Arrays.fill(dp, 10);
				min = 10;
				K = Integer.parseInt(br.readLine());
				
				min = minCard(0);
				sb.append(min==10?-1:min).append("\n");
			}
		}
		System.out.println(sb);
	}
	private static int minCard(int result) {
		if(result > K) return 10;
		if(result == K) return 0;
		if(dp[result]!=10) return dp[result];
		
		int min = 10;
		for(int i=0;i<N;i++) {
			if (arr[i] == 0 && result == 0)continue;
			else if (arr[i] == 0)min = Math.min(min, minCard(result * 10));
			else if (arr[i] == 1 || result == 0)min = Math.min(min, minCard(result * 10 + arr[i]));
			else 
				min = Math.min(min, Math.min(minCard(result * 10 + arr[i]), minCard(result*arr[i]) + 1));
		}
		return min;
	}
}
