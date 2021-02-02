package com.ps.sw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954 {
	static int T, N, x, y, count;
	static int[][] field;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			x = -1;
			y = 0;
			count = 0;
			N = Integer.parseInt(br.readLine());
			field = new int[N][N];
			cycle(N, 1);
			sb.append("#").append(tc).append("\n");
			for (int[] s : field) {
				for (int ss : s) {
					sb.append(ss).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void cycle(int n, int d) {
		if (n==0) return;
		for (int i = 0; i < (2*n-1); i++) {
			if (i < n)
				x += d;
			else
				y += d;
			field[y][x] = ++count;
		}
		cycle(n - 1, d * (-1));
	}
}
