package com.baek.graph.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13905 {
	static int N,M,S,E;
	static class Edge implements Comparable<Edge>{
	    int end;
	    int value;
	 
	    Edge(int end, int value) {
	        this.end = end;
	        this.value = value;
	    }

		@Override
		public int compareTo(Edge o) {
			return o.value - value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		ArrayList<Edge> edges[] = new ArrayList[N+1];
		int[] dist = new int[N+1];
		boolean visit[] = new boolean[N+1];
		
		for(int i = 0;i<=N;i++) {
			edges[i] = new ArrayList<Edge>();
		}
		
		st = new StringTokenizer(br.readLine());
		S= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		
        
        dist[S] = Integer.MAX_VALUE;
        
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[start].add(new Edge(end,w));
			edges[end].add(new Edge(start,w));
		}
		
		PriorityQueue <Edge> pq = new PriorityQueue <Edge>();
		pq.add(new Edge(S,0));	
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(visit[cur.end]) continue;
			visit[cur.end] = true;
			for(int i =0 ;i < edges[cur.end].size();i++) {
				int next = edges[cur.end].get(i).end;
				int cost = edges[cur.end].get(i).value;
				dist[next]= Math.max(dist[next], Math.min(dist[cur.end], cost));
				pq.add(edges[cur.end].get(i));
			}
 		}
		
		System.out.println(dist[E]);
	}

}
