package com.baek.dfsbfs.gol12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1103 {
	static int N, M, max;
	static boolean infi = false;
	static char[][] arr;
	static int[][] depth, delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		depth = new int[N][M];
		arr = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		visit[0][0] = true;
		dfs(0, 0, 1);
		
		System.out.println(infi?-1:max);
	}

	private static void dfs(int x, int y, int cnt) {
		
		max = Math.max(cnt, max);
		depth[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + (arr[x][y]-'0')*delta[i][0];	
			int ny = y + (arr[x][y]-'0')*delta[i][1];
			
			if(!inside(nx,ny) || arr[nx][ny]=='H')
				continue;
			
			if(depth[nx][ny] > cnt)
				continue;
			
			if (visit[nx][ny]) {
				infi = true;
				return;
			}
			visit[nx][ny] = true;
			dfs(nx, ny, cnt + 1);
			if(infi) return;
			visit[nx][ny] = false;
		}
	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
