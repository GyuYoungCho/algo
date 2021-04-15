package com.ps.sw.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {
	static int T,N,M,R,C,L,cnt;
	static int[][] arr, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visit, pipe= {{true,true,true,true}, {true,false,true,false},
			{false,true,false,true},{false,true,true,false},{true,true,false,false}
			,{true,false,false,true},{false,false,true,true}};
	static Queue<int []> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			q = new LinkedList<>();
			visit[R][C] = true;
			cnt = 1;
			q.add(new int[] {R,C,1});
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				if(temp[2] >=L) break;
				
				for (int d = 0; d < 4; d++) {
					int nx = temp[0] + delta[d][0];
					int ny = temp[1] + delta[d][1];
					if (nx<0||nx>=N||ny<0||ny>=M || visit[nx][ny] || arr[nx][ny]==0) continue;
					
					if(pipe[arr[temp[0]][temp[1]] - 1][d] && pipe[arr[nx][ny] - 1][(d+2)%4]) {
						cnt++;
						visit[nx][ny] = true;
						q.offer(new int[] {nx,ny,temp[2] + 1});
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
