package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;



public class Solution_1249 {
	static int T, N, min;
	static final int INF = Integer.MAX_VALUE;
	static char[][] arr;
	static int[][] dist;
	static boolean[][] visit;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
        	min = Integer.MAX_VALUE;
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			dist = new int[N][N];
			visit = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }
			for( int i=0; i<N; i++) {
				Arrays.fill(dist[i], INF);
			}
			
			dij(0,N-1);
			sb.append(min).append("\n");
			
        }
		System.out.println(sb);
	}
	private static void dij(int sx, int ex) {
		PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2) ->o1[2]-o2[2]);
        pq.add(new int[] {sx,sx, 0});
        dist[0][0] = 0;
        visit[0][0] = true;
        
        while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();

			int x= cur[0];
			int y= cur[1];
			int depth = cur[2];
			
			if ( x == ex && y == ex	) {
				min = depth;
				return;
			}
			
			for( int d=0; d<4; d++) {
				
				int nx = x + delta[d][0];
				int ny = y + delta[d][1];
				
				if (inside(nx,ny) && !visit[nx][ny])
				{
					visit[nx][ny] = true;
					pq.add( new int[] {nx,ny, depth + arr[nx][ny] - '0'}) ;
				}
				
			}
		}
    }
	public static boolean inside(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
