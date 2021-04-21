package com.baek.imple.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B15683 {
	static int N,M, cctv, min = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][][] ccDir = {
            {{0}},
            {{1}, {2}, {3}, {0}},
            {{1, 3}, {0, 2}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},
            {{0, 1, 2, 3}},
    };

	static List<int []> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>0 && arr[i][j]<6) {
					list.add(new int[] {i,j});
				}
			}
		}
		cctv = list.size();
		dfs(0, arr);
		System.out.println(min);
	}
	
	private static void dfs(int idx, int map[][]) {
		if(idx==cctv) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==0) sum++;
				}
			}
			if(sum==0) {
				for (int i = 0; i < N; i++) {
					System.out.println(Arrays.toString(map[i]));
				}
			}
			min = Math.min(sum, min);
			return;
		}
		
		int[] cur = list.get(idx);
		int type = map[cur[0]][cur[1]];
		for (int i = 0; i < ccDir[type].length; i++) {		
			int[][] temp = copy(map);
			for (int j = 0; j < ccDir[type][i].length; j++) {
				int d = ccDir[type][i][j];
				int nx = cur[0];
				int ny = cur[1];
				while (true) {
					nx += delta[d][0];
					ny += delta[d][1];
					if(notin(nx,ny)||temp[nx][ny]==6) break;
					if(temp[nx][ny] == -1 || (temp[nx][ny]>0 && temp[nx][ny]<6)) continue;
					temp[nx][ny] = -1;
				}
			}
			dfs(idx+1,temp);
        }
	}
	
	private static int[][] copy(int[][] map) {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
	
	private static boolean notin(int x, int y) { 
		 return x < 0 || x >= N || y < 0 || y >= M; 
	}

}
