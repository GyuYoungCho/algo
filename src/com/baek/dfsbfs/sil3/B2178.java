package com.baek.dfsbfs.sil3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
	static int N, M;
	static char[][] field;
	static int[][] delta = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static Point start, end;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		field = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			field[i] = br.readLine().toCharArray();
		}
		start = new Point(0, 0, 0);
		end = new Point(N - 1, M - 1, 0);

		System.out.println(goend(start)+1);

	}

	static int goend(Point at) {
		Queue<Point> q = new LinkedList<>();
		q.offer(at);
		visited[at.x][at.y] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == end.x && p.y == end.y) {
				return p.cnt;
			}
			for (int d = 0; d < 4; d++) {
				int dx = p.x + delta[d][0];
				int dy = p.y + delta[d][1];

				if (inside(dx, dy) && !visited[dx][dy] && field[dx][dy] == '1') {
					visited[dx][dy] = true;
					q.offer(new Point(dx, dy, p.cnt + 1));
				}
			}
		}
		return -1;
	}

	static boolean inside(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < M;
	}

}

class Point {
	int x;
	int y;
	int cnt;

	public Point(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}