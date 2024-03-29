package com.baek.graph.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14938 {
	static int N, M, R, S,E,D, max;
	static final int MAX = 987654321;
	static int[] item, visitDis;
	
	static int [][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		item = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j)
					graph[i][j] = MAX;
			}
		}
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            graph[S][E] =D ;
            graph[E][S] =D;
		}
		
		for (int k = 1; k <= N; k++)
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
				{
					if (graph[i][k] + graph[k][j] < graph[i][j])
						graph[i][j] = graph[i][k] + graph[k][j];
				}

		for (int i = 1; i <= N; i++)
		{
			int cnt = 0;
			for (int j = 1; j <= N; j++)
			{
				if (graph[i][j] <= M) 
					cnt += item[j];
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}
