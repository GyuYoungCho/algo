package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1208 {

	static StringTokenizer st;
	static int dump, max, min, max_idx, min_idx;
	static StringBuilder sb = new StringBuilder();
	static int[] box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			box = new int[101];
			int t;
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i <= dump; i++) {
				if (i != 0) {
					box[max_idx]--;
					box[min_idx]++;
				}
				min = 101;
				max = 0;
				for (int j = 0; j < 100; j++) {
					if (max < box[j]) {
						max = box[j];
						max_idx = j;
					}
					if (min > box[j]) {
						min = box[j];
						min_idx = j;
					}
				}
				if (max - min == 0 || max - min == 1)
					break;
			}
			sb.append("#").append(test_case).append(" ").append(max-min).append("\n");
			System.out.println(sb);
		}
		
	}

}
