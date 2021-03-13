package com.baek.graph45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14938 {
	static int N, M, R, S,E,D, max;
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
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            graph[S][E] =D ;
            graph[E][S] =D;
		}
		
		for (int i = 1; i <= N; i++) {
			visitDis = new int[N+1];
			Arrays.fill(visitDis, -1);
	        max = Math.max(max, dfs(i, 0));
	        
	    }
		System.out.println(max);
	}

	private static int dfs(int n, int d) {
		int cnt=0;
		if(visitDis[n]==-1) cnt = item[n];
		visitDis[n] = d;
		
		for (int i = 1; i <= N; i++) {
			if(n==i || graph[n][i]==-0) continue;
	        int dist = d + graph[n][i];
	        
	        if (dist <= M && visitDis[i]==-1) {
	            cnt += dfs(i, dist);
	            
	        }
	    }
		
		return cnt;
	}

}
