package com.ps.sw.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1265 {
	static int T,N,P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			long a=1;
			int n = N%P;
			N/=P;
			P-=n;
			while(n-->0) {
				a*=(N+1);
			}
			while(P-->0) {
				a*=N;
			}
			sb.append(a).append("\n");
		}
		System.out.println(sb);
	}

}
