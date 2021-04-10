package com.baek.graph45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504 {
	static int N,E , n1,n2;
	static final int INF = 200000000;
	static List<int[]> list[];
	static boolean[] visit;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        dist = new int[N + 1];

        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());         
            list[s].add(new int[] {e,w});
            list[e].add(new int[]{s, w});
        }
        st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        
        int ans1 = 0;
        int ans2 = 0; 
        ans1 += dijkstra(1, n1);
        ans1 += dijkstra(n1, n2);
        ans1 += dijkstra(n2, N);
        
        
        ans2 += dijkstra(1, n2);
        ans2 += dijkstra(n2, n1);
        ans2 += dijkstra(n1, N);
        if (ans1 >= INF && ans2 >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(ans1, ans2));
	}
	
	private static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        visit = new boolean[N+1];
        
        PriorityQueue<int []> queue = new PriorityQueue<>((o1,o2) ->o1[1]-o2[1]);
        queue.add(new int[] {start, 0});
        dist[start] = 0;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int next = cur[0];
            int cost = cur[1];

            if(visit[next] == true) continue;
            visit[next] = true;

            for(int i = 0; i < list[next].size(); i++){
                int nextN = list[next].get(i)[0];
                int nextW = list[next].get(i)[1];
                
                if(!visit[nextN] && dist[nextN] > cost + nextW){
                    dist[nextN] = cost + nextW;
                    queue.add(new int[]{nextN, dist[nextN]});
                }
            }
        }
        return dist[end];
    }
}
