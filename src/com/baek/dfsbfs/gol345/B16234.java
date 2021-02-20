package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16234 {
	
	private static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static int N, L, R, nx,ny;
	static int[][] arr, delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static Queue<Point> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
				}
			}
		}
	}

	private static int bfs(int x, int y) {
		int sum = 0, num=0;
	    q = new LinkedList<>();
	    q.add(new Point(x,y));
	    
	    while(!q.isEmpty()) {
	    	Point p = q.poll();
	    	sum+=arr[p.x][p.y];
	    	num++;
	    	
	    	for(int i=0;i<4;i++) {
	    		nx = p.x+delta[i][0];
	    		ny = p.y+delta[i][1];
	    		if(inside(nx,ny)) {
	    			q.add(new Point(nx,ny));
	    		}
	    	}
	    }
		return sum/num;
	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
