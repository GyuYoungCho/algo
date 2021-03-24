package com.baek.graph45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11404 {
	static int N, M, S,E,D, max;
	static final int MAX = 987654321;
	static int [][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j)
					graph[i][j] = MAX;
			}
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            graph[S][E] = Math.min(graph[S][E], D);
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++){
					if (graph[i][k] + graph[k][j] < graph[i][j])
						graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == MAX) {
                    graph[i][j] = 0;
                }
 
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
	}

}
