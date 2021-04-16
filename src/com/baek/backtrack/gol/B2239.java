package com.baek.backtrack.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2239 {
	static int arr[][] = new int[9][9];
	static boolean flag;
	static boolean[][] row = new boolean[9][10], col = new boolean[9][10], 
			square = new boolean[9][10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(s.charAt(j)+"");
				if(arr[i][j]!=0) {
					row[i][arr[i][j]] = true;
					col[j][arr[i][j]] = true;
					square[idx(i,j)][arr[i][j]] = true;
				}
			}
		}
		
		dfs(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int cnt) {
		if(cnt==81) { 
			flag = true;
			return;
		}
		
		int x = cnt/9;
		int y = cnt%9;
		
		if(arr[x][y]!=0) dfs(cnt+1);
		else {
			for (int i = 1; i < 10; i++) {
				if(!col[y][i] && !row[x][i] && !square[idx(x,y)][i]) {
					arr[x][y] = i;
					col[y][i] = true;
					row[x][i] = true;
					square[idx(x,y)][i] = true;
					dfs(cnt+1);
					if(flag) return;
					arr[x][y] = 0;
					col[y][i] = false;
					row[x][i] = false;
					square[idx(x,y)][i] = false;
				}
			}
		}
	}
	private static int idx(int x, int y) {
		return y/3 + (x/3)*3;
	}
}
