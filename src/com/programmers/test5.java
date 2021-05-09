package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class test5 {
	static final int INF = 3001;
	public static void main(String[] args) {
		int n = 4;
		int s =1;
		int e = 4;
		int[][] roads = {{1,2,1},{3,2,1},{2,4,1}};
		int[] trap= {2,3};
		System.out.println(solution(n,s,e,roads,trap));
	}
	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int arr[][] = new int[n+1][n+1];
		
		int answer = 0;
        boolean[] check = new boolean[n+1];
        
        for(int i=0; i<traps.length;i++)
        	check[traps[i]] = true;
       
		int[] dist = new int[n+1];

        
        dist[start] = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i],INF);
		}
        
		for (int i = 0; i < 3; i++) {
			int s = roads[i][0];
			int e = roads[i][1];
			int w = roads[i][2];
			arr[s][e] = Math.min(arr[s][e],w);
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		Arrays.fill(dist, INF);
		dist[start] = 0;
		for (int i = 0; i < n-1; i++) { 
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			for (int j = 0; j < n; j++) { 
				if(min > dist[j]) {
					min = dist[j];
					index = j;
				} 
			} 
			
			for (int j = 0; j < n; j++) {
				if(arr[index][j] != 0 && dist[index] + arr[index][j] < dist[j])
					dist[j] = dist[index] + arr[index][j];
			} 
			check[index] = true; 
		}
		
//		while(!pq.isEmpty()) {
//			int[] cur = pq.poll();
//			int now = cur[0];
//			if(check[now]) {
//				for(int i =0 ;i < edges[now].size();i++) {
//					int[] next = edges[now].get(i);
//					int temp = next[0];
//					next[0] = now;
//					edges[now].remove(i);
//					edges[temp].add(next);
//					System.out.println(temp + " " + Arrays.toString(next));
//				}
//			}
//			
//			for(int i =0 ;i < edges[now].size();i++) {
//				int next = edges[now].get(i)[0];
//				int cost = edges[now].get(i)[1];
//				if(dist[next] > cost +cur[1] ){
//                    dist[next] = cost + cur[1];
//                    pq.add(new int[]{next, dist[next]});
//                }
//				
//			}
// 		}
		
        return dist[end];
    }
}
