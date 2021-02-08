package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5215 {
	static int T, N, L,score, kal;
	static int [] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			arr = new int[L+1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int T = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken()); 
                for (int l = L; l >= K; l--) { 
                    int pre = arr[l];
                    int up = arr[l - K] + T;
                    arr[l] = up > pre ? up : pre;               
                }
			}
			sb.append("#").append(tc).append(" ").append(arr[L]).append("\n");
		}
		System.out.println(sb);
	}
}
