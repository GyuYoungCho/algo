package com.baek.dp.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12783 {
	static int T, N,M,K, all, min = 20;
	static int[] arr;
	static int[] dp = new int[1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Arrays.fill(dp, min);
			
			all = 0;
			
			for (int i = 0; i < N; i++) {
				int a = Integer.parseInt(st.nextToken());
				all +=1<<a;
				
			}
			
			M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				
				K = Integer.parseInt(br.readLine());
				int ans = minCard(K);
				sb.append(min==ans?-1:ans).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	private static int minCard(int cnt) {
		if(dp[cnt]!=min) return dp[cnt];
		
		int cv = cnt;
		int cur = 0;

		while (cv>0) {
			cur |= 1 << (cv % 10);
			cv /= 10;
		}

		if ((cur & all) == cur)dp[cnt] = 0;
		else
			dp[min] = min;
		
		
		for (int i=2 ;i*i<=cnt;i++) {
			if(cnt%i==0) {
				dp[cnt] = Math.min(dp[cnt], minCard(i) +  minCard(cnt/i) + 1);
			}
		}
		return dp[cnt];
		//		if (result < arr[0])
//			return;
//
//		int temp = result;
//		while (true)
//		{
//			if (temp == 0)
//			{
//				min = cnt < min ? cnt : min;
//				return;
//			}
//			boolean flag = false;
//			for (int i = 0; i < N; i++)
//				if (temp % 10 == arr[i])
//				{
//					flag = true;
//					break;
//				}
//			if (!flag)
//				break;
//			temp /= 10;
//		}
//
//		for (int i = 0; i < N; i++)
//			if (arr[i] > 1 && result % arr[i] == 0)
//				minCard(result / arr[i], cnt + 1);
	}
}
