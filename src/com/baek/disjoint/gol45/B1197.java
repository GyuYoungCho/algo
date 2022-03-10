package com.baek.disjoint.gol45;

import java.io.*;
import java.util.*;

public class B1197 {
	static int parent[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v+1];
        for(int i = 1; i <= v; i++)
            parent[i]= i;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2] );
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {a, b, w});
        }
        
        int weight = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(find(now[0]) != find(now[1])) {
                union(now[0], now[1]);
                weight += now[2];
            }
        }
        
        System.out.println(weight);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
