package com.baek.graph45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
	static int V,E,S,start, end, w;
	static ArrayList<Edge>[] list;
	static int[] dist;
	
	static class Edge {
	    int end;
	    int value;
	 
	    Edge(int end, int value) {
	        this.end = end;
	        this.value = value;
	    }
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine());
		
		dist = new int[V + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);

        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Edge>();
        }
        
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			list[start].add(new Edge(end,w));
		}
		
		go(S);
		
		for(int i = 1; i <= V; i++){
            sb.append((dist[i] == Integer.MAX_VALUE)?"INF":dist[i]).append("\n");
        }
		System.out.println(sb);
	}

	private static void go(int start) {
	    PriorityQueue<Integer> q = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(check[cur] == true) continue;
            check[cur] = true;
            
            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i).end; 
                int value = list[cur].get(i).value; 
 
                if (dist[next] > dist[cur] + value) {
                    dist[next] = Math.min(dist[next], value + dist[cur]);
                    q.add(next);
 
                }
 
            }
       }
	}

}
