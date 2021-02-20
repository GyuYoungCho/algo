package com.baek.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15240 {
	static int N, M, R, C;
	static char color, now_color;
	static char[][] arr;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];

		for (int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		color = st.nextToken().charAt(0);

		now_color = arr[R][C];
		if (now_color != color)
			dfs(R, C);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int r, int c) {
		arr[r][c] = color;
		for (int i = 0; i < 4; i++) {
			int nx = r + delta[i][0];
			int ny = c + delta[i][1];
			if(inside(nx,ny)&&arr[nx][ny]==now_color)
				dfs(nx,ny);
		}
	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
