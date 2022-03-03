package com.baek.graph.gol45;

import java.util.*;
import java.io.*;


public class B12893 {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] team;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
	
		graph = new ArrayList[N+1];
		team = new int[N+1];
		Arrays.fill(team, -1);
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int ans = 1;
		
		for (int i = 1; i <= N; i++) {
			if (team[i] == -1) ans = bfs(i);
			
			if (ans == 0) break;
		}
		System.out.println(ans);
		
	}
	
	private static int bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {start, 0});
		team[start] = 0;
		
		int result = 1;
		while (!q.isEmpty() && result != 0) {
			int[] cur = q.poll();
			
			int part = (cur[1]+1) % 2;
			for (int next_v : graph[cur[0]]) {
				if (team[next_v] == -1) {
					q.offer(new int[] {next_v, part});
					team[next_v] = part;
				} else {
					if (part != team[next_v]) {
						result = 0;
						break;
					}
				}
			}
			
		}
		
		return result;
		
	}
}
