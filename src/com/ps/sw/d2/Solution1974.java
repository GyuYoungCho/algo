package com.ps.sw.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1974 {
	static int [][] field = new int[9][9] ;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				st.
				int max = 0;
				field = new int[N][N];
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					max = Math.max(max, getsum(i, j));
				}
			}

			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
