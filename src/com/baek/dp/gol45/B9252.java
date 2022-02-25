package com.baek.dp.gol45;

import java.io.*;

public class B9252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(), sbs = new StringBuilder();
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		int a = str1.length, b= str2.length, ans=0;
		int[][] dp = new int[a+1][b+1];
		
		for(int i=1;i<=a;i++) {
			for(int j=1;j<=b;j++) {
				if(str1[i-1] == str2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}	
		sb.append(dp[str1.length][str2.length]).append("\n");
		
		while(a>=1 && b>=1) { 
			if(dp[a][b] == dp[a-1][b])
                a--;
            else if(dp[a][b] == dp[a][b-1])
                b--;
            else {
                sbs.append(str2[b-1]);
                a--; b--;
            }
		}
		sb.append(sbs.reverse());
		System.out.println(sb);
	}
}
