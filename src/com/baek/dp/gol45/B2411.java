package com.baek.dp.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2411 {
	static int N,M,A,B;
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		int a=0,b=0;
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a][b] = 2;
		}
		
		a=1; b=1;
		int cnt=1;
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=M; j++) {
				// 아이템이면 이전 위치에서 올 수 있는 가지수 세기
				if(arr[i][j]==1) {
					cnt*= go(i,j,a,b);
					a=i; 
					b=j;
				}
			}
		}
		if(arr[N][M]!=1) //마지막 아이템 없을 경우
			cnt*= go(N,M,a,b);
		System.out.println(cnt);
		
	}
	private static int go(int px, int py, int x, int y) {
		// 시작점 기준 1로 채우기
		for(int i = x;i<=px;i++){
	        if(arr[i][y] == 2)break;
	        dp[i][y] = 1;
	    }
	    for(int i = y;i<=py;i++){
	        if(arr[x][i] == 2)break;        
	        dp[x][i] = 1;
	    }
	    // 오른쪽 위쪽 갈 수 있는 경우의 수
	    for(int i = x+1;i<=px;i++){
	        for(int j = y+1;j<=py;j++){
	            if(arr[i][j] != 2)
	                dp[i][j] = dp[i][j-1] + dp[i-1][j];
	        }
	    }
	    return dp[px][py];
	}

}
