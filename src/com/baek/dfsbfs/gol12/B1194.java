package com.baek.dfsbfs.gol12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1194 {
	static int N,M, sx,sy,cnt;
	static char[][] arr;
	static boolean[][][] visit;
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M][64];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(arr[i][j]=='0') {
					sx =i;
					sy = j;
				}
			}
		}
		
		Queue<int []> q1 = new LinkedList<>();
		
		q1.offer(new int[] {sx,sy,0,0});
		
		boolean flag = false;
		visit[sx][sy][0] = true;
		
		while(!q1.isEmpty()) {
			int[] cur = q1.poll();
			
			int key = cur[3];
			
			if(arr[cur[0]][cur[1]]=='1') {
				cnt = cur[2];
				flag = true;
				break;
			}
			for (int d = 0; d < 4; d++){
                int ny = cur[1] + delta[d][1];
                int nx = cur[0] + delta[d][0];
                
                if(notin(nx,ny)||arr[nx][ny]=='#'|| visit[nx][ny][key]) continue;
                
                if('a'<= arr[nx][ny] && 'f'>= arr[nx][ny]) {
                	int nkey = key | (1 << arr[nx][ny]-'a');
                	if(!visit[nx][ny][nkey]) {
                		visit[nx][ny][nkey] = true;
                		
                		q1.offer(new int[]{nx,ny,cur[2]+1, nkey});
                	}
                }
                else if('A'<= arr[nx][ny] && 'F'>= arr[nx][ny]) {
                	if((key & (1 << (arr[nx][ny] - 'A'))) > 0) {
                		q1.offer(new int[]{nx,ny,cur[2]+1, key});
                		visit[nx][ny][key]= true;
                	}
                }
                else {
                	q1.offer(new int[]{nx,ny,cur[2]+1,key});
                	visit[nx][ny][key] = true;
                }
            }
		}
		System.out.println(flag?cnt:-1);
	}
	
	private static boolean notin(int x, int y) { 
		 return x < 0 || x >= N || y < 0 || y >= M; 
	}
}
