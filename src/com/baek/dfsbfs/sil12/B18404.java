package com.baek.dfsbfs.sil12;

import java.io.*;
import java.util.*;

public class B18404 {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int N,M,x,y;
	static int[][] arr, delta = {{-2,-1},{2,-1},{-2,1},{2,1},{1,2},{-1,2},{1,-2},{-1,-2}};
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		visit = new boolean[N+1][N+1];
		arr = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		x = stoi(st.nextToken());
		y = stoi(st.nextToken());
		q.add(new int[] {x,y,0});

		visit[x][y] = true;
		
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 8; d++) {
				int nx = cur[0] + delta[d][0];
				int ny = cur[1] + delta[d][1];

				if (nx<1||ny<1||nx>N||ny>N||visit[nx][ny]) continue;
				visit[nx][ny] = true;
				arr[nx][ny] = cur[2]+1;
				q.offer(new int[] {nx,ny,cur[2]+1});
			}
		}
		
		for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = stoi(st.nextToken());
    		y = stoi(st.nextToken());
    		sb.append(arr[x][y]).append(" ");
        }
		System.out.println(sb);
	}
}
