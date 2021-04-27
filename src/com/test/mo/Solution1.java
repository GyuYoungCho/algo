package com.test.mo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1 {
	static int T,N;
	static int[][] arr, map, ji, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[] team;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			map = new int[N][N];
			ji = new int[N][N];
			
			team = new int[4];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					team[arr[i][j]]++;
				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ji[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			e:while(true) {
				for(int i=1;i<4;i++) {
					if(team[i]!=0) simulate(i);
					int end=0;
					for(int k=1;k<4;k++) {
						if(team[k]==0) end++;
					}
					if(end==2) break e;
				}
				
			}
			int ans=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ans+=map[i][j];
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void simulate(int t) {
		
		int[][] count = new int[N][N];
		int[][] newteam = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]!=t&&arr[i][j]!=0) {
					int sum = 0;
					List<int []> de= new ArrayList<>(); 
					for (int d = 0; d < 4; d++) {
						int nx = i + delta[d][0];
						int ny = j + delta[d][1];
						if(notin(nx,ny)) continue;
						
						if(arr[nx][ny]==t) {
							sum+=map[nx][ny];
							de.add(new int[] {nx,ny,map[nx][ny]/4});
						}
					}
					if (map[i][j]*5 < sum) {
						int all=0;
						for(int[] cur : de) {
							count[cur[0]][cur[1]]++;
							all+=cur[2];
						}
						map[i][j] = all - map[i][j];
						newteam[i][j] = t;
						team[t]++;
						team[arr[i][j]]--;
					}else newteam[i][j] = arr[i][j];
				}else newteam[i][j] = arr[i][j];
			}
		}
		arr = newteam;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] -= map[i][j]/4 * count[i][j];
			}
		}
		
		
		
		count = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==t) {
					int cnt=0;
					for (int d = 0; d < 4; d++) {
						int nx = i + delta[d][0];
						int ny = j + delta[d][1];
						if(notin(nx,ny)) continue;
						if(arr[nx][ny]!=t && arr[nx][ny]!=0)cnt++;
					}
					if(cnt!=0) {
						int ccnt = 0;
						for (int d = 0; d < 4; d++) {
							int nx = i + delta[d][0];
							int ny = j + delta[d][1];
							if(notin(nx,ny)) continue;
							
							if(arr[nx][ny]==t && 5 * map[nx][ny] < map[i][j]) {
								ccnt++;
								count[nx][ny]+=map[i][j]/5;
							}
						}
						count[i][j] -= (map[i][j]/5)*ccnt;
					}else {
						int ccnt = 0;
						for (int d = 0; d < 4; d++) {
							int nx = i + delta[d][0];
							int ny = j + delta[d][1];
							if(notin(nx,ny)) continue;
							if (arr[nx][ny]==t) {
								ccnt++;
								count[nx][ny]+=map[i][j]/5;
							}
						}
						count[i][j] -= (map[i][j]/5)*ccnt;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += count[i][j];
			}
		}
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]+=ji[i][j];
			}
		}
	}
	private static boolean notin(int x, int y) {
		return x<0 || x>=N || y<0 || y>=N;
	}
}
