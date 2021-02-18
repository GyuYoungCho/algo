package com.baek.backtrack.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1987 {
	static int R, C, max = 0;
	static char[][] arr;
	static boolean alpha[] = new boolean[26];
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		dfs(1,0,0);
		System.out.println(max);
	}

	private static void dfs(int cnt, int r, int c) {
		
		alpha[arr[r][c] - 'A'] = true;
		
		
		for (int i = 0; i < 4; i++) {
			int nx = r + delta[i][0];
			int ny = c + delta[i][1];
			if (inside(nx,ny)&&!alpha[arr[nx][ny] - 'A'])
				dfs(cnt+1,nx,ny);
		}
		alpha[arr[r][c] - 'A'] = false;
		max = Math.max(max, cnt);
	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
