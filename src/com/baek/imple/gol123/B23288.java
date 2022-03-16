package com.baek.imple.gol123;

import java.io.*;
import java.util.*;

public class B23288 {
	static int n,m,k,ans, cnt, dir,x,y;
	static int[][] arr, dice = {{6,1},{2,5},{3,4}};
	static int[] dx= {0,1,0,-1}, dy= {1,0,-1,0};
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			if(!valid(x+dx[dir],y+dy[dir])) 
				dir= (dir+2)%4;
			
			x+=dx[dir];
			y+=dy[dir];
			
			if(dir==0) {
				int[] now = new int[] {dice[2][0],dice[2][1]};
				dice[2][0] = dice[0][1];
				dice[2][1] = dice[0][0];
				dice[0] = now;
			}else if(dir==1) {
				int[] now =  new int[] {dice[0][0], dice[0][1]};
				dice[0][0] = dice[1][1];
				dice[0][1] = dice[1][0];
				dice[1] = now;
			}else if(dir==2) {
				int[] now =  new int[] {dice[0][0], dice[0][1]};
				dice[0][0] = dice[2][1];
				dice[0][1] = dice[2][0];
				dice[2] = now;
			}else {
				int[] now =  new int[] {dice[1][0],dice[1][1]};
				dice[1][0] = dice[0][1];
				dice[1][1] = dice[0][0];
				dice[0] = now;
			}
			
			if(dice[0][0] > arr[x][y]) dir= (dir+1)%4;
			else if(dice[0][0] < arr[x][y]) dir= (dir+3)%4;
			
			visit = new boolean[n][m];
			cnt = 1;
			visit[x][y] = true;
			dfs(arr[x][y],x,y);
			
			ans += arr[x][y] * cnt;
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int num, int nx,int ny) {
		for(int i=0;i<4;i++) {
			int vx = nx + dx[i];
			int vy = ny + dy[i];
			
			if(!valid(vx,vy)|| visit[vx][vy] || arr[vx][vy]!=num) continue;
			cnt++;
			visit[vx][vy] = true;
			dfs(num,vx,vy);
		}
	}
	
	static boolean valid(int nx, int ny) {
        if(nx < 0 || nx >= n || ny < 0 || ny >= m) return false;
        return true;
    }
}
