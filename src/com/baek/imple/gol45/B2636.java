package com.baek.imple.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2636 {
	static int M,N, count;
	static boolean[][] visit;
	static int[][] arr, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int cnt=0;
		while(cheese()) {
			cnt++;
			visit = new boolean[N][M];
			visit[0][0] = true;
			count = 0;
			melt(0,0);
		}
		System.out.println(cnt +"\n" + count);
	}

	private static boolean cheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == -1) {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}

	private static void melt(int x, int y) {
		for(int d=0;d<4;d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			
			if(inside(nx,ny)&&!visit[nx][ny]) {
				visit[nx][ny] = true;
				if(arr[nx][ny] == 1) {
					arr[nx][ny] = -1;
					count++;
				}else {
					melt(nx,ny);
				}
			}
		}
	}
	
	public static boolean inside(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
