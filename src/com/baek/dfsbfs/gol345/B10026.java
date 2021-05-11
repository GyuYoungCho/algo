package com.baek.dfsbfs.gol345;

import java.io.*;
import java.util.*;

public class B10026 {
	static int N;
	static char[][] arr;
	static boolean[][] visit;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int[] r = new int[2];
		for (int k = 0; k < 2; k++) {
			for(int i=0;i<N;i++) {
	            for(int j=0;j<N;j++) {
	                if(!visit[i][j]) {
	                    r[k]++;
	                    dfs(i,j,arr[i][j]);
	                }
	                if(arr[i][j]=='G') arr[i][j]='R';
	            }
	        }
			visit=new boolean[N][N];
		}
		sb.append(r[0] + " "+r[1]);
        
		System.out.println(sb);
	}
	
	private static void dfs(int x, int y, char c) {
		visit[x][y]= true;
		for (int d = 0; d < 4; d++) {
            int nx = x + delta[d][0];
            int ny = y + delta[d][1];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N || 
            		visit[nx][ny] || arr[nx][ny] != c)
                continue;
            dfs(nx,ny,c);
        }
	}

}
