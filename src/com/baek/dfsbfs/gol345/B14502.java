package com.baek.dfsbfs.gol345;

import java.io.*;
import java.util.*;

public class B14502 {
	static int N,M,max;
	static int[][] arr, visit, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(max);
	}
	
	public static void dfs(int count) {

		if(count == 3) {
			bfs();
			
			return;
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) {	
					arr[i][j] = 1;
					dfs(count+1);	
					arr[i][j] = 0;	
				}
			}
		}
	}

	private static void bfs() {
	
		visit = new int[N][M];

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visit[i][j] = arr[i][j];
			}
		}

		q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 2) {
					q.add(new int[] {i,j});
				}
			}
		}

		while(!q.isEmpty()) {
			int[] p = q.poll();

			for(int i=0; i<4; i++) {
				int nx = p[0] + delta[i][0];
				int ny = p[1] + delta[i][1];
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(visit[nx][ny] == 0) {
						visit[nx][ny] = 2;
						q.add(new int[]{nx, ny});
					}
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j] == 0) cnt ++;
			}
		}
		max = Math.max(max, cnt);
	}
}
