package com.baek.dfsbfs.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
	static int N,M,V;
	static List[] graph;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		visit = new boolean[N + 1];
		
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }
        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
	}
	private static void bfs(int v2) {
		Queue<Integer> queue = new LinkedList<>();
        queue.add(v2);
        visit = new boolean[N + 1];
        visit[v2] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int head = queue.poll();
                sb.append(head).append(" ");
                List<Integer> childs = graph[head];
                for (int i = 0; i < childs.size(); i++) {
                    if (!visit[childs.get(i)]) {
                        visit[childs.get(i)] = true;
                        queue.add(childs.get(i));
                    }
                }
            }
        }
        
	}
	private static void dfs(int v2) {
		visit[v2] = true;
		sb.append(v2).append(" ");
		
		List<Integer> nodes = graph[v2];
		for (Integer c : nodes) {
            if (!visit[c]) {
                dfs(c);
            }
        }
	}

}
