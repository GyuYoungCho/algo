package com.ps.sw.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2115 {
	static int T, N,M,C, ans;
	static int arr[][], map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			map = new int[N][N-M+1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N-M+1; j++) {
					comb(i,j,0,0,0);
				}
			}
			
			ans = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-M+1;j++) {
					int sum = map[i][j];
					for(int k=j+M;k<N-M+1;k++) {
						ans = Math.max(ans, sum + map[i][k]);					
					}
					for(int k=i+1;k<N;k++) {
						for(int l=0;l<N-M+1;l++) {
							ans = Math.max(ans, sum + map[k][l]);
						}
					}
				}
			}

			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void comb(int i, int j, int cnt,int sum,int ssum) {
		if(sum >C) return;
		if(cnt==M) {
			map[i][j-M] = Math.max(map[i][j-M], ssum);
			return;
		}
		comb(i,j+1,cnt+1,sum+arr[i][j], ssum+arr[i][j]*arr[i][j]);
		comb(i,j+1,cnt+1,sum, ssum);
	}

}
