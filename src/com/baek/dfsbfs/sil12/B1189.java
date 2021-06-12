package com.baek.dfsbfs.sil12;

import java.util.*;
import java.io.*;

public class B1189 {

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int R,C,K;
	static char[][] arr;
	static boolean[][] visited;
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		K = stoi(st.nextToken());
		arr = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		visited = new boolean[R][C];
		visited[R-1][0] = true;
		ans = 0;
		bfs(R-1,0,1);
		System.out.println(ans);
		
	}
	
	private static void bfs(int y, int x, int cnt) {
		if(cnt > K) return;
		if(y == 0 && x == C-1) {
			if(cnt == K) ans+=1;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny >= R || ny < 0 || nx >= C || nx < 0) continue;
			if(arr[ny][nx] == '.' && !visited[ny][nx]) {
				visited[ny][nx] = true;
				bfs(ny,nx,cnt+1);
				visited[ny][nx] = false;
			}
			
		}
		
	}

}
