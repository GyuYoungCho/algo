package com.baek.tree;

import java.io.*;
import java.util.*;

public class B3584 {
	static int T,N;
	static int[] parent, depth;
	static boolean[] visit;
	static LinkedList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			list = new LinkedList[N+1];
			
			parent = new int[N+1];
			depth = new int[N+1];
			visit = new boolean[N+1];
			for (int j = 1; j <= N; j++) {
				list[j] = new LinkedList<Integer>();
			}
	
			for(int j = 0; j < N-1; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
	
				visit[b] = true;
	
				list[a].add(b);
				list[b].add(a);
			}
	
			int root = 0;
			for(int j = 1; j <= N; j++) {
				if(!visit[j]) {
					root = j;
					break;
				}
			}
			dfs(root, 0, -1);
			
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			
			int a = depth[v1];
			int b = depth[v2];
		
			while(a > b) {
				v1 = parent[v1];
				a--;
			}
			
			while(b > a) {
				v2 = parent[v2];
				b--;
			}
			while(v1 != v2) {
				v1 = parent[v1];
				v2 = parent[v2];
			}
			sb.append(v1).append("\n");
		}
		System.out.println(sb);
	}
	

	private static void dfs(int root, int d, int p) {
		depth[root] = d;
		parent[root] = p;
		
		for(int node : list[root]) {
			if(node != p) {
				dfs(node, d+1, root);
			}
		}
	}

}
