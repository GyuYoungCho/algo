package com.baek.backtrack.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16432 {
	static int N, K;
	static boolean flag;
	static int arr[][], dp[];
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][10];
		visit = new boolean[N+1][10];
		dp = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				arr[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}
		
		get(0,0);
		
		if(flag) {
			for(int i=0;i<N;i++) {
				sb.append(dp[i]).append("\n");
			}
		}else sb.append(-1);
		
		System.out.println(sb);
	}
	
	private static void get(int num, int next) {
		if(next==N) {
			flag = true;
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			if(num==i) continue;
			if(arr[next][i]==1 && !visit[next+1][i]) {
				visit[next+1][i] = true;
				dp[next]=i;
				get(i,next+1);
				if(flag) return;
			}
		}
	}
}
