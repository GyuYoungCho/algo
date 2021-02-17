package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17135 {
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static Queue<Point> q;
	static int N, M, D, count = 0, enemy = 0, all_enemy = 0, church = 0, max = 0;
	static char[][] arr;
	static boolean[] check;
	static int[] num = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		check = new boolean[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if (arr[i][j] == '1')
					all_enemy++;
			}
		}
		search(0, 0);
		System.out.println(max);
	}

	public static void search(int cnt, int start) {
		if (cnt == 3) {
			church = 0;
			enemy = all_enemy;
			char[][] copy = deepCopy(arr);
			attack(copy);
			max = Math.max(max, church);
			
			return;
			
		}

		for (int i = start; i < M; i++) {
			check[i] = true;
			num[cnt] = i;
			search(cnt + 1, i + 1);
			check[i] = false;
		}
	}

	private static void attack(char[][] copy) {
		int all = 0;
		while (enemy != 0) {
			q = new LinkedList<>();
			e: for (int i = 0; i < 3; i++) {
				for (int s = 0; s < D; s++) {
					for (int j = num[i] - s, t = 0; j <= num[i] + s; j++) {
						if (j <= num[i]) {
							if (inside(N - 1 - t, j) && copy[N - 1 - t][j] == '1') {
								q.add(new Point(N - 1 - t, j));
								continue e;
							}
							t++;
						} else {
							if (inside(N - 1 - t + 2, j) && copy[N - 1 - t + 2][j] == '1') {
								q.add(new Point(N - 1 - t + 2, j));
								continue e;
							}
							t--;
						}
					}
				}
			}
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				if(copy[p.x][p.y] == '1') {
					copy[p.x][p.y] ='0';
					enemy--;
					church++;
				}
			}
			move(all++, copy);
		}
		return;
	}

	private static void move(int n, char[][] copy) {
		for (int j = M - 1; j >= 0; j--) {
			if (copy[N - 1][j] == '1') {
				copy[N - 1][j] = '0';
				enemy--;
			}
		}
		for (int i = N - 2; i >= n; i--) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == '1') {
					copy[i][j] = '0';
					copy[i + 1][j] = '1';
				}
			}
		}
	}

	static char[][] deepCopy(char[][] orig) {
		if (orig == null)
			return null;
		char[][] cp1 = new char[orig.length][orig[0].length];

		for (int i = 0; i < orig.length; i++) {
			cp1[i] = orig[i].clone();
		}
		return cp1;
	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
