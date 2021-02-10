package com.baek.imple.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16926 {
	static int N, M, R, nx, ny, temp, value;
	static int[][] arr;
	static int[][] delta = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Math.min(N, M) / 2;
		int s = R;
		
		for (int i = 0; i < min; i++) {
			if (M * N != 4) {
				s = R / (2 * M + 2 * N - 4 - 8*i) == 0 ? R : R % (2 * M + 2 * N - 4 -8*i);
			}
			while (s > 0) {
				int x = i, y = i;
				temp = 0;
				value = arr[x][y];
				arr[x][y] = arr[x][y + 1];
				int d = 0;
				while (d < 4) {
					nx = x + delta[d][0];
					ny = y + delta[d][1];
					if (nx >= i && ny >= i && nx < N - i && ny < M - i) {
						temp = arr[nx][ny];
						arr[nx][ny] = value;
						value = temp;
						x = nx;
						y = ny;
					} else
						d++;
				}
				arr[i][i] = temp;
				s--;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
