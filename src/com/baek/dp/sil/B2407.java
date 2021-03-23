package com.baek.dp.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B2407 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		BigInteger[][] dp = new BigInteger[N+1][N+1];
		BigInteger one = new BigInteger("1");
		dp[1][0] = one;
		dp[1][1] = one;
		for(int i=2;i<=N;i++) {
			for (int j = 0; j <=i; j++) {
				if(j==0||j==i) dp[i][j] = one;
				else
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
		System.out.println(dp[N][M]);
	}

}
