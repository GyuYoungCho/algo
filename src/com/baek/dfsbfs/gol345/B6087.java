package com.baek.dfsbfs.gol345;

import java.io.*;
import java.util.*;

public class B6087 {

	private static int w, h;
	private static char[][] arr;
	private static int[][] visit;
	private static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	private static int[] start, end;
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new char[h][w];
		visit = new int[h][w]; 
		
		for (int i = 0; i < h; i++) { 
			Arrays.fill(visit[i], w * h); 
		} 
		boolean flag = false; 
		for (int i = 0; i < h; i++) {
			arr[i] = br.readLine().toCharArray(); 
			for (int j = 0; j < w; j++) { 
				if (arr[i][j] == 'C') { 
					if (flag) 
						end = new int[] {i, j, 0, 4}; 
					else { 
						start = new int[]{i, j, 0, 4};
						flag = true; 
					} 
				} 
			} 
		} 
		
		int answer = bfs();
		System.out.println(answer); 
	} 
	
	private static int bfs() {
		Queue<int[]> queue = new PriorityQueue<>(
				(o1, o2) -> Integer.compare(o1[2], o2[2])
				);
		visit[start[0]][start[1]] = 0;
		queue.add(start);
		int[] node;
		while (!queue.isEmpty()) {
			node = queue.poll(); 
			if (node[0] == end[0] && node[1] == end[1]) return node[2];
			for (int i = 0; i < 4; i++) { 
				int nx = node[0] + delta[i][0]; 
				int ny = node[1] + delta[i][1];
				if (inside(nx, ny) || arr[nx][ny] == '*') continue;
				if (node[3] == i || node[3] == 4) { 
					if (visit[nx][ny] >= node[2]) {
						visit[nx][ny] = node[2]; 
						queue.add(new int[]{nx, ny, node[2], i}); 
					} 
				} else { 
					if (visit[nx][ny] >= node[2] + 1) {
						visit[nx][ny] = node[2] + 1; 
						queue.add(new int[]{nx, ny, node[2] + 1, i});
					} 
				}
			} 
		} 
		return -1; 
	} 
	
	private static boolean inside(int x, int y) {
		return x < 0 || y < 0 || x >= h || y >= w;
	} 
}
