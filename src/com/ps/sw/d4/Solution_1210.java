package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {
	static int t, end, arrive;
	static int[] delta = { -1, 1 };
	static int[][] field;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		boolean Goleftright;
		
		for (int tc = 1; tc <= 10; tc++) {
			t = Integer.parseInt(br.readLine());
			field = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 100; i++) {
				if (field[99][i] == 2) {
					arrive = i;
					end = 99;
					while (end != 0) {
						Goleftright = false;
						for (int d = 0; d < 2; d++) {
							int x = arrive + delta[d];
							if (inside(x)) {
								if (field[end][x] == 1) {
									arrive = x;
									Goleftright = true;
									while (true) {
										x = arrive + delta[d];
										if (!inside(x) || field[end][x] == 0)
											break;
										arrive = x;
									}
								}
							}
							if(Goleftright) break;
						}
						end--;
					}
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(arrive).append("\n");
		}
		System.out.println(sb);
	}

	static boolean inside(int x) {
		return x >= 0 && x < 100;
	}
}
