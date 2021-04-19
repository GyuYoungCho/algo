package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458 {
	static int T,N;
	static int arr[][], dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		e:for (int tc = 1; tc <= T; tc++) {
			int max_d = 0;
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			dp = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				dp[i] = Math.abs(arr[i][0]) + Math.abs(arr[i][1]);
				max_d = Math.max(max_d, dp[i]);
			}
			int se = max_d%2;
			for (int i = 1; i < N; i++) {
				if(dp[i]%2!=se) {
					sb.append(-1).append("\n");
					continue e;
				}
			}
			
			int cnt = 0, y = 0, ans = 0;
			while (true) {
				y += cnt;
				if (y >= max_d && y % 2 == se) {
					ans = cnt;
					break;
				}
				cnt++;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
