package com.ps.sw.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1263 {
	static int T,N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N =  Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) { 
                for (int j = 0; j < N; j++) { 
                	arr[i][j] = Integer.parseInt(st.nextToken());
                	if(arr[i][j]==0) arr[i][j] = 100000;
                	if(i==j) arr[i][j] = 0;
                }
            }

            for (int k = 0; k < N; k++) {
    			for (int i =0; i < N; i++) {
    				for (int j = 0; j < N; j++) {
    					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
    				}
    			}
            }
			
            int min = 100000;
    		for (int i=0; i < N; i++) {
    			int temp = 0;
    			for (int j = 0; j < N; j++) {
    				if(i!=j)
    					temp += arr[i][j];
    			}
    			min = Math.min(min, temp);
    		}
    		
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
	}

}
