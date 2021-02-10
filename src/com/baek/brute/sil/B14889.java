package com.baek.brute.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889 {

	static int N;
	static int[][] map;
	static boolean[] visit;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
 
		map = new int[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0,0);
		System.out.println(min);
	}
	
	static void combi(int cnt, int idx) {
		if(cnt == N / 2) {
			int sum1=0,sum2=0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visit[i] == true && visit[j] == true) {
						sum1 += map[i][j];
						sum1 += map[j][i];
					}
					else if (visit[i] == false && visit[j] == false) {
						sum2 += map[i][j];
						sum2 += map[j][i];
					}
				}
			}
			int diff = Math.abs(sum1-sum2);
			min = Math.min(diff, min);
			return;
		}
 
		for(int i = idx; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				combi(cnt + 1,i+1);
				visit[i] = false;
			}
		}
	}
	
}
