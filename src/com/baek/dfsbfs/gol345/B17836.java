package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17836 {
	static int N,M,T;
	static int[][] arr, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {0,0,0});
		visit[0][0][0] = true;
		boolean flag = false;
		int time = 10001;
		for (int i = 0; i <= T; i++) {
			int size = q.size();
			while (size-->0) {
				int[] cur = q.poll();
				if(cur[0]==N-1 && cur[1]==M-1) {
					flag = true;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + delta[d][0];
					int ny = cur[1] + delta[d][1];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny][cur[2]==1?1:0]) continue;
					if (arr[nx][ny] == 1 && cur[2]==0) continue;
					visit[nx][ny][cur[2]==1?1:0] = true;
					
					if (cur[2] == 0) {
						q.offer(new int[] {nx, ny, arr[nx][ny]==2?1:0});		
					}
					else {
						
						q.offer(new int[] {nx, ny, 1});
						
					}
				}
			}
			
			if(flag) {
				time = i;
				break;
			}
		}
		System.out.println(time!=10001?time:"Fail");
	}

}
