package com.baek.dfsbfs.gol345;

import java.io.*;
import java.util.*;

public class B16947 {
	static boolean visit[], isCycle;
	static int N, distance[];
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, -1);
		
		ArrayList<Integer> adj[] = new ArrayList[N+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		dfs(adj,0,1);
		bfs(adj);
		
		for (int i = 1; i <= N; i++) {
			sb.append(distance[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	private static void dfs(ArrayList<Integer>[] adj, int prev, int curr) {
		visit[curr] = true;

		for (int next : adj[curr]) {
			if (visit[next] && next != prev) {
				isCycle = true;
				distance[next] = 0;
				queue.add(next);
				break;
			} else if (!visit[next]) {
				dfs(adj, curr, next);
				if (isCycle) {
					if (distance[next] == 0) {
						isCycle = false;
					} else {
						distance[next] = 0;
						queue.add(next);
					}
					return;
				}
			}
		}
	}
	private static void bfs(ArrayList<Integer>[] adj) {
		int cnt=1;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int j = 0; j < len; j++) {
				int tmp = queue.poll();
				for (int i : adj[tmp]) {
					if (distance[i] != -1) continue;
					distance[i] = cnt;
					queue.add(i);
				}
			}
			cnt++;
		}
	}

}
