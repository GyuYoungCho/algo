package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class test04 {
	static int INF = 987654321;
	public static void main(String[] args) {
		int n = 4;
		int s =1;
		int e = 4;
		int[][] roads = {{1,2,1},{3,2,1},{2,4,1}};
		int[] trap= {2,3};
		System.out.println(solution(n,s,e,roads,trap));
	}
	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        boolean[] check = new boolean[n+1];
        
        for(int i=0; i<traps.length;i++)
        	check[traps[i]] = true;
       
        ArrayList<int[]> edges[] = new ArrayList[n+1];
		int[] dist = new int[n+1];
//		boolean visit[] = new boolean[n+1];
		
		for(int i = 0;i<=n;i++) {
			edges[i] = new ArrayList<int[]>();
		}
        
        dist[start] = Integer.MAX_VALUE;
        
		for (int i = 0; i < roads.length; i++) {
			int s = roads[i][0];
			int e = roads[i][1];
			int w = roads[i][2];
			edges[s].add(new int[] {e,w,1});
			edges[e].add(new int[] {s,w,-1});
		}
		
		PriorityQueue <int[]> pq = new PriorityQueue <int[]>(
				(o1,o2) -> Integer.compare(o1[1],o2[1])
		);
		pq.add(new int[]{start,0});	
		Arrays.fill(dist, INF);
		int min = INF;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int now = cur[0];
			if(now==end) {
				min = Math.min(min, cur[1]);
				continue;
			}
			if(check[now]) {
				for(int i =0 ;i < edges[now].size();i++) {
					edges[now].get(i)[2] *= -1;
				}
			}
			
			for(int i =0 ;i < edges[now].size();i++) {
				if(edges[now].get(i)[2]==1) {
					int next = edges[now].get(i)[0];
					int cost = edges[now].get(i)[1];
					System.out.println(now + " " + next + " " +cost);
					
	                dist[next] = cost + cur[1];
	            
	                pq.add(new int[]{next, dist[next]});
	                
				}
			}
 		}
		
        return dist[end];
    }
}
