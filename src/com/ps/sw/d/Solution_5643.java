package com.ps.sw.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5643 {
	static int T, N,M, ans, INF = 501;
	static int arr[][], order[];
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			arr = new int[N + 1][N + 1];
	        
	        for (int i = 1; i <= N; i++) {
	            Arrays.fill(arr[i], INF);
	            arr[i][i] = 0;
	        }
	        for (int i = 0; i < M; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	int r = Integer.parseInt(st.nextToken());
	        	int c = Integer.parseInt(st.nextToken());
	            arr[r][c] = 1;
	        }
	
	        for (int k = 1; k <= N; k++) {
	            for (int i = 1; i <= N; i++) {
	                for (int j = 1; j <= N; j++) { 
	                	arr[i][j] = Math.min(arr[i][j],arr[i][k] + arr[k][j]);
	                }
	            }
	        }
	
	        order = new int[N + 1];
	        for (int i = 1; i <= N; i++) {
	            for (int j = 1; j <= N; j++) {
	            	if(i==j) continue;
	                if (arr[i][j] != INF) {
	                    order[i]++;
	                    order[j]++;
	                }
	            }
	        }
	        
	        ans = 0;
	        for (int i = 1; i <= N; i++) {
	            if (order[i] == N - 1) {
	                ans++;
	            }
	        }
	        sb.append(ans).append("\n");
		}
        System.out.println(ans);

	}

}
