package com.baek.divide.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1992 {
	static char[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		divide(N, 0, 0);
		System.out.println(sb);
	}

	private static void divide(int idx, int row, int col) {
		if (idx == 1) {
			sb.append(arr[row][col]);
			return;
		}
		if (allsame(row, col, idx))
			sb.append(arr[row][col]);
		else {
			sb.append("(");
			divide(idx / 2, row, col);
			divide(idx / 2, row, col + idx / 2);
			divide(idx / 2, row + idx / 2, col);
			divide(idx / 2, row + idx / 2, col + idx / 2);
			sb.append(")");
		}
	}

	private static boolean allsame(int x, int y, int range) {
		char s = arr[x][y];
		for (int i = x; i < x + range; i++) {
			for (int j = y; j < y + range; j++) {
				if (s != arr[i][j])
					return false;
			}
		}
		return true;
	}
}
