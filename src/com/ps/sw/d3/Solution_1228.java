package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1228 {
	static String line;
	static int N, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			ArrayList<Integer> base = new ArrayList<>();
			st = new StringTokenizer(br.readLine());

			int t = 0;
			while (st.hasMoreTokens()) {
				base.add(Integer.parseInt(st.nextToken()));
			}

			L = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < L; i++) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for (int k = 0; k < end; k++) {
					base.add(idx++, Integer.parseInt(st.nextToken()));
				}
			}

			sb.append("#").append(tc).append(" ");

			for (int i = 0;i<10;i++) {
				sb.append(base.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
