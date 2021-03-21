package com.test;

import java.io.*;

class SCO2 {
	static char[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr= new char[N];
		long [] dp = new long[N+1];
		dp[0] = 0;dp[1] = 1;
		arr = br.readLine().toCharArray();
		int zero=0,one = 0;
		for(int i=1;i<N;i++) {
			if(arr[i]=='0') {
				i++;
				dp[i+1] = dp[i-1];
			}else {
				dp[i+1] = dp[i] + dp[i-1];
			}
		}
		System.out.println(dp[N]);
	}
}
