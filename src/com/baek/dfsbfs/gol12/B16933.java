package com.baek.dfsbfs.gol12;


import java.io.*;
import java.util.*;

public class B16933 {
	static int N,M,K, answer;
	static int[][] arr, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean day;
	static boolean[][][] visit;
	static Queue<int[]> q = new LinkedList<>();
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M][K+1];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		q.offer(new int[] {0,0,0,1});
		visit[0][0][0] = true;
		
		answer = -1;
		e:while (!q.isEmpty()) {
			int size = q.size();
			while(size-->0) {
				int[] cur = q.poll();
	
				if (cur[0] == N-1 && cur[1] == M-1) {
					answer =  cur[3];
					break e;
				}
	
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + delta[i][0];
					int nc = cur[1] + delta[i][1];
	
					if ((nr >=0 && nr < N) && (nc >=0 && nc < M)) {
						if (arr[nr][nc] == 0 && !visit[nr][nc][cur[2]]) {
							q.offer(new int[] {nr, nc, cur[2], cur[3]+1});
							visit[nr][nc][cur[2]] = true;
						}
	
						else if (arr[nr][nc] == 1 && cur[2] < K && !visit[nr][nc][cur[2] + 1]) {
							if(day) {
								q.offer(new int[] {cur[0], cur[1], cur[2], cur[3] + 1});
							}else {
								q.offer(new int[] {nr, nc, cur[2] + 1, cur[3] + 1});
								visit[nr][nc][cur[2] + 1] = true;
							}
						}
					}
				}
				
			}
			day = !day;
		}
		
		System.out.println(answer);
	}

}