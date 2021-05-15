package com.baek.dfsbfs.gol345;

import java.io.*;
import java.util.*;

public class B2206 {
	static int N,M, ans;
	static char[][] arr;
	static int[][] delta = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static boolean[][][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visit = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0,0,0,1});
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==N-1 && cur[1]==M-1) {
				ans = cur[3];
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + delta[i][0];
				int ny = cur[1] + delta[i][1];
				
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				char next = arr[nx][ny];
				
				if(cur[2]==0) {
					if(next=='0'&&!visit[nx][ny][0]) {
						q.offer(new int[] {nx,ny,cur[2],cur[3]+1});
						visit[nx][ny][0] = true;
					}else if(next=='1') {
						q.offer(new int[] {nx,ny,cur[2]+1,cur[3]+1});
						visit[nx][ny][0] = true;
					}
				}
				else {
					if(next=='0' &&!visit[nx][ny][1]) {
						q.offer(new int[] {nx,ny,cur[2],cur[3]+1});
						visit[nx][ny][1] = true;
					}
				}
			}
		}
		System.out.println(ans==0?-1:ans);
		
	}

}
