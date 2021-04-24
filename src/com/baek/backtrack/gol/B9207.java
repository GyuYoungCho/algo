package com.baek.backtrack.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B9207 {
	static int T,N=5,M=9, minCnt, minMove;
	static char[][] arr;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static List<int[]> pin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		arr = new char[N][M];
		while(T-- > 0) {
			pin = new ArrayList<>();
			minCnt = Integer.MAX_VALUE;
			minMove = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < s.length(); j++) {
					arr[i][j] = s.charAt(j);
					if(arr[i][j] == 'o') {
						pin.add(new int[] {i,j});
					}
				}
			}
			dfs(0,pin.size(),0);
			sb.append(minCnt).append(" ").append(minMove).append("\n");
			if(T!=0)br.readLine();
		}
		System.out.println(sb);
	}
	private static void dfs(int idx, int cnt, int m) {
		if(cnt < minCnt) {
			minCnt = cnt;
			minMove = m;
		}else if(cnt==minCnt){
			minMove = Math.min(minMove, m);
		}
		
		for(int i = 0; i < pin.size(); i++) {
			int[] p = new int[] {pin.get(i)[0], pin.get(i)[1]};
			if(arr[p[0]][p[1]] != 'o')
				continue;
			
			for(int d = 0; d < 4; d++) {
				int nx = p[0] + delta[d][0];
				int ny = p[1] + delta[d][1];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny]!='o') continue;
				
				int nnx = nx + delta[d][0];
				int nny = ny + delta[d][1];
				if(nnx< 0 || nny< 0 || nnx>= N || nny >= M || arr[nnx][nny]!='.') continue;
				
				arr[p[0]][p[1]] = '.';
				arr[nx][ny] = '.';
				arr[nnx][nny] = 'o';
				pin.get(i)[0] = nnx;
				pin.get(i)[1] = nny;
				dfs(i +1, cnt-1, m + 1);
				pin.get(i)[0] = p[0];
				pin.get(i)[1] = p[1];
				arr[p[0]][p[1]] = 'o';
				arr[nx][ny] = 'o';
				arr[nnx][nny] = '.';
			}
		}
	}

}
