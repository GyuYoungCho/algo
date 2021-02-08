package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229 {
	static int T, N, M, max;
	static int[] snack, arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			snack = new int[N];
			
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			arr = new int[2];
			search(0,0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
		
	public static void search(int depth, int start) {
		if (depth == 2) {
			int sum = arr[0]+arr[1];
			if(sum<=M && sum>max)
				max = sum;
			return;
		}
		for (int i = start; i < N; i++) {
			arr[depth] = snack[i];
			search(depth + 1, i+1);
		}
	}
}
