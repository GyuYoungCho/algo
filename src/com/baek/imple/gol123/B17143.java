package com.baek.imple.gol123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B17143 {
	static int N,M,K;
	static int delta[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	static List<int[]>[][] arr;
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new List[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new int[] {r,c,s,d,z});
		}
		
		int ans=0;
		for(int i = 0; i < M; i++) {
			if(list.isEmpty()) break;
			for(int [] cur : list) {
				if(cur[1] == i) arr[cur[0]][cur[1]].add(cur);
			}
			
			for(int j = 0; j < N; j++) {
				if(!arr[j][i].isEmpty()) {
					int[] cur = arr[j][i].get(0);
					ans+=cur[4];
					list.remove(cur);
					arr[j][i].clear();
					break;
				}
			}
			for(int j = 0; j < N; j++) {
				arr[j][i].clear();
			}
			for(int [] cur : list) {
				int d = cur[3];
				if(d<=2) {
					int nx = cur[0];
					int move = cur[2]%(2*(N-1));
					while(move>0) {
						if(nx==0) d = 2;
						if(nx== N-1) d=1;
						nx+=delta[d-1][0];
						move--;
					}
					cur[0] = nx;
					cur[3] = d;
					arr[nx][cur[1]].add(cur);
				}else{
					int ny = cur[1];
					int move = cur[2]%(2*(M-1));
					while(move>0) {
						if(ny==0) d = 3;
						if(ny== M-1) d=4;
						ny+=delta[d-1][1];
						move--;
					}
					cur[1] = ny;
					cur[3] = d;
					arr[cur[0]][ny].add(cur);
				}
			}
			
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					
					if(arr[j][k].size() < 2) {
						arr[j][k].clear();
						continue;
					}
					int max = 0;
					for(int[] cur : arr[j][k]) {
						max = Math.max(cur[4], max);
					}
					for(int[] cur : arr[j][k]) {
						if(cur[4]!=max) list.remove(cur);
					}
					
					arr[j][k].clear();
					
				}
			}
			
		}
		System.out.println(ans);
	}
}
