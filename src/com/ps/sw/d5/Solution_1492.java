package com.ps.sw.d5;

import java.io.*;
import java.util.*;

public class Solution_1492 {
	static int T,N,M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1][3];
			long[] pops = new long[N+2];
			long[] corns = new long[N+2];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<3;j++) {
	                arr[i][j] = Integer.parseInt(st.nextToken());
	            }
				pops[i+1] = 1;
			}
			
			int n_popcorn = 0;
			
			for (int i = 0; i < M; i++) {
	            for (int j = 1; j <= N; j++) {
	                corns[j-1] += pops[j]*arr[j][0] % 1000000007;
	                corns[j] += pops[j]*arr[j][1] % 1000000007;
	                corns[j+1] += pops[j]*arr[j][2] % 1000000007;
	            }
	            for (int j = 1; j <= N; j++) {
	                pops[j] = corns[j];
	                pops[j] %= 1000000007;
	                n_popcorn += pops[j];
	                n_popcorn %= 1000000007;
	                corns[j] = 0;
	            }
	        }
			sb.append(n_popcorn).append("\n");
		}
		System.out.println(sb);
	}

}
