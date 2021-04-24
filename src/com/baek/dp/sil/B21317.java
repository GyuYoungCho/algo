package com.baek.dp.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B21317 {
	static int N,K;
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new int[N+2][2];
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < N+2; i++) {
			Arrays.fill(dp[i], 1000000);
		}
		dp[0][0] = 0; dp[0][1] = 0;
	    
	    for(int i=0; i<N-1; i++) {
	        
	        for(int j=0; j<2; j++) {
	            dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+arr[i][0]);
	            dp[i+2][j] = Math.min(dp[i+2][j], dp[i][j]+arr[i][1]);
	        }
	        dp[i+3][1] = Math.min(dp[i+3][1], dp[i][0]+K);
	    }
	    System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
	}

}
