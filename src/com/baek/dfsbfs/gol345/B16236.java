package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 {
	static int N, size=2, cnt,ans;
	static boolean visit[][];
	static int[][] arr, delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int mini[] = new int[3];
	static ArrayList<int[]> fishes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					mini[0] = i;
					mini[1] = j;
					arr[i][j]=0;
				}
			}
		}

		while(true) {
			fishes = new ArrayList<int []>(); 
			Queue<int []> q = new LinkedList<>(); 
			visit = new boolean[N][N]; 
			q.offer(mini); 
			visit[mini[0]][mini[1]] = true;

			while(!q.isEmpty()) {
				int[] shark = q.poll();

				for(int d = 0; d < 4; d++) {
					int nx = shark[0] + delta[d][0];
					int ny = shark[1] + delta[d][1];

					if(!inside(nx, ny) || visit[nx][ny]) continue; 
					if(arr[nx][ny]>=1 && arr[nx][ny] < size){ 
						q.offer(new int[]{nx, ny, shark[2] + 1});
						fishes.add(new int[]{nx, ny, shark[2] + 1}); 
						visit[nx][ny] = true; 
					} 

					else if(arr[nx][ny] == size || arr[nx][ny] == 0) {
						q.offer(new int[]{nx, ny, shark[2] + 1});
						visit[nx][ny] = true; 
					}
				} 
			}

			if(fishes.size() == 0) {
				System.out.println(ans);
				return;
			}

			
			int[] fish = fishes.get(0);
			for(int i = 1; i < fishes.size(); i++){
				if(fishes.get(i)[2] < fish[2]) {
					fish = fishes.get(i);
				}

				if(fishes.get(i)[2] == fish[2]) { 
					if(fish[0] > fishes.get(i)[0]){
						fish = fishes.get(i);
					}   
				}
			}

			ans += fish[2];
			cnt++;
			arr[fish[0]][fish[1]] = 0; 

			if(cnt == size) {
				size++;
				cnt = 0;
			}
			
			mini = new int[3];
			mini[0] = fish[0];
			mini[1] = fish[1]; 
			
		}
	}

	public static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
