package com.test;

import java.io.*;
import java.util.*;

class SCO5 {
	static int N, M, min = Integer.MAX_VALUE;
	static boolean flag;
	static char[][] arr;
	static boolean[][] visit;
	static int[][] delta = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
			if (i == 0) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 'c')
						list.add(j);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			visit = new boolean[N][M];
			visit[0][list.get(i)] = true;
			dfs(0, list.get(i), 0);
		}
		System.out.println(flag?min:-1);

	}

	private static void dfs(int r, int c, int cnt) {
		if(cnt>min) return;
		if (r == N - 1) {
			
			min = Math.min(min, cnt);
			System.out.println(min);
			flag = true;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = r + delta[d][0];
			int ny = c + delta[d][1];
			
			if(inside(nx,ny)&&!visit[nx][ny]&&arr[nx][ny]=='.') {
				visit[nx][ny] = true;
				if(d%2==1)
					dfs(nx,ny,cnt+1);
				else
					dfs(nx,ny,cnt);
				
			}
		}
	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
