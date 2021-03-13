package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1937 {
	static int N, max;
	static int[][] arr,depth,delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		depth = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(depth[i],-1);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				max = Math.max(max,dfs(i,j));
			}
		}
		System.out.println(max);
	}
	
	private static int dfs(int x, int y) {
		
		
		if(depth[x][y]!=-1) return depth[x][y];
		depth[x][y] = 1;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + delta[i][0];	
			int ny = y + delta[i][1];
			
			if(!inside(nx,ny)|| arr[nx][ny] <=arr[x][y] )
				continue;
			
			cnt = Math.max(cnt, dfs(nx, ny));
			
		}
		depth[x][y] += cnt;
		return depth[x][y];
	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
