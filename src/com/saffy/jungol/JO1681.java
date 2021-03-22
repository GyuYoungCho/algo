package com.saffy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1681 {
	static int N,min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());

		arr= new int[N][N];
		visit = new boolean[N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0);
		System.out.println(min);
	}
	public static void dfs(int start, int idx, int cost) {
		if ( cost >= min ) {
			return;
		}
		
		if ( idx == N-1) {
			if ( arr[start][0] !=0 ) {
				min = Math.min(min, cost + arr[start][0]);
			}
			return;	
		}
		
		
		
		for( int i=1; i<N; i++) {
			if (arr[start][i] != 0 && !visit[i]) { 
				visit[i] = true;
				dfs(i, idx+1, arr[start][i] + cost);
				visit[i] = false;
			}
		}	
	}
}
