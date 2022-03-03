package com.baek.graph.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11562 {
	static int N,M, ans, INF = 501;
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            arr[u][v] = 0;
            arr[v][u] = (b == 0) ? 1 : 0;
        }
        
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) { 
                	arr[i][j] = Math.min(arr[i][j],arr[i][k] + arr[k][j]);
                }
            }
        }
        
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
 
            sb.append(arr[s][e] + "\n");
        }
        System.out.println(sb);
	}

}
