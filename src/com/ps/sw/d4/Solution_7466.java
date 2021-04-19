package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7466 {
	static int T,N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken())+1;
			K = Integer.parseInt(st.nextToken());
			
			if(N>=K) {
				sb.append(K);
			}else {
				int a = 1;
				while(N-->1) {
					if(K%N==0) {
						a*=N;
						K/=N;
					}
				}
				sb.append(a);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
