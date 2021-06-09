package com.baek.imple.gol45;

import java.io.*;
import java.util.*;

public class B8972 {
	static int R,C;
	static int[][] delta = {{1,-1},{1,0},{1,1},{0,-1},{0,0},{0,1},{-1,-1},{-1,0},{-1,1}};
	static char[][] arr;
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		arr = new char[R][C];
		
		LinkedList<int []> adu = new LinkedList<>();
		int jx=0,jy=0;
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
			
			for (int j = 0; j < C; j++) {
				if(arr[i][j]=='R') {
					adu.add(new int[] {i,j});
				}
				else if(arr[i][j]=='I') {
					jx = i;
					jy = j;
				}
			}
		}
		
		String cmd = br.readLine();
		
		
		for (int i = 0; i < cmd.length(); i++) {
			char[][] cmap = new char[R][C];
			int d = cmd.charAt(i)-'0';
			
			jx += delta[d - 1][0];
			jy += delta[d - 1][1];
			
			if (arr[jx][jy] == 'R') {
				System.out.println("kraj " + (i + 1));
				return;
			}
			
			cmap[jx][jy] = 'I';
			
			while (!adu.isEmpty()) {
				int[] cur= adu.poll();
				
				int min = Integer.MAX_VALUE;
				int[] next = new int[2];
				
				for (int j = 0; j < 9; j++) {
					
					int nx = cur[0] + delta[j][0];
					int ny = cur[1] + delta[j][1];
					
					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
						int diff = Math.abs(jx - nx) + Math.abs(jy - ny);
						min = Math.min(min, diff);
						if (min == diff) {
							next = new int[]{nx, ny};
						}
						
					}
				}
				
				if (cmap[next[0]][next[1]] != '\0') {
					if (arr[next[0]][next[1]] =='I') {
						System.out.println("kraj " + (i + 1));
						return;
					}
					
					cmap[next[0]][next[1]] = 'X'; 
				}
				else {
					cmap[next[0]][next[1]] = 'R';
				}
				
			}
			
			for (int j = 0;  j < R; j++) {
				for (int k = 0; k < C; k++) {
					if (cmap[j][k] == '\0' || cmap[j][k]=='X') {
						arr[j][k] = '.';
					}
					else {
						if (cmap[j][k]=='R') {
							adu.add(new int[] {j, k});
						}
						
						arr[j][k] = cmap[j][k];
					}
				}
			}
			
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
