package com.baek.dfsbfs.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1325 {
	static int N, M, A, B, max=0;
	static int[] count;
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		count = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr[B].add(A);
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			count[i] = dfs(i);
		}
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, count[i]);
		}
		for (int i = 1; i <= N; i++) {
			if(count[i]==max)
				sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	private static int dfs(int node) {
		visited[node] =true;
		int num = 1;
		for(int no : arr[node]) {
			if(visited[no]) continue;
			num+=dfs(no);
		}
		return num;
	}
//	private static void bfs(int node) {
//		visited[node] =true;
//		for(int no : arr[node]) {
//			if(!visited[no]) {
//				count[no]++;
//				dfs(no);
//			}
//		}
//		
//	}
}
