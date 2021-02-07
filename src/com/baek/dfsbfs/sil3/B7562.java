package com.baek.dfsbfs.sil3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
	static int T, I, x, y;
	static int[][] delta = {{-2,-1},{2,-1},{-2,1},{2,1},{1,2},{-1,2},{1,-2},{-1,-2}};
	static boolean[][] visited;
	static Point start,end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = parse(br.readLine());

		for (int i = 0; i < T; i++) {
			I = parse(br.readLine());
			visited = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine());
			start = new Point(parse(st.nextToken()),parse(st.nextToken()),0); 
			st = new StringTokenizer(br.readLine());
			end = new Point(parse(st.nextToken()),parse(st.nextToken()),0);
			System.out.println(end.y);
			sb.append(gozero(start)).append("\n");
		}
		System.out.println(sb);
	}
	
	static int gozero(Point at) {
		Queue<Point> q = new LinkedList<>();
		q.offer(at);
		visited[at.x][at.y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.x == end.x && p.y == end.y) {
				return p.cnt;
			}

			for (int d = 0; d < 8; d++) {
				int dx = p.x + delta[d][0];
				int dy = p.y + delta[d][1];

				
				if (inside(dx,dy) && !visited[dx][dy]){
					visited[dx][dy] = true;
					q.offer(new Point(dx, dy, p.cnt + 1));
				}
			}
		}

		return -1;
		
	}
	
	static int parse(String s) {
		return Integer.parseInt(s);
	}

	static boolean inside(int nx, int ny) {
		return nx >= 0 && nx < I && ny >= 0 && ny < I;
	}

}

class Point{
	int x;
	int y;
	int cnt;
	public Point(int x, int y,int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
}