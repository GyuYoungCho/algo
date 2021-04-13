package com.ps.sw.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014 {
	static int T, N, M;
	static int[][] arr, arr2;
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
			arr = new int[N][N];
			arr2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					arr2[j][i] = arr[i][j];
				}
			}
			
			int ans=0;
			for (int i = 0; i < N; i++) {
				ans+=check(arr[i]);
			}
			for (int i = 0; i < N; i++) {
				ans+=check(arr2[i]);
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int check(int[] road) {
		boolean[] visit = new boolean[N];

		for (int i = 0; i < N-1; i++) {
			int prev = road[i];
			int next = road[i+1];
			if(Math.abs(next-prev)>1) return 0;
			if(prev==next||visit[i+1]) continue;
			
			if (prev < next) {
				for (int j = i ; j > i - M; j--) {
					if(j<0 || road[j]!=prev||visit[j]) return 0;
					visit[j] = true;
				}
					
			}else {
				for (int j = i+1 ; j <= i + M; j++) {
					if(j>=N || road[j]!=next||visit[j]) return 0;
					visit[j] = true;
				}
			}
		}
		return 1;
	}

}
