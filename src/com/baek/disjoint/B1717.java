package com.baek.disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 {
	static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            if (command == 0) {
                union(a, b);
            } else{
                sb.append((find(a)==find(b) ? "YES" : "NO") + "\n");
            }
        }
        System.out.println(sb);
	}
	
	public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
 
        return parent[x] = find(parent[x]);
    }
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x==y) return;
        
        if (rank[x] < rank[y]) {
            parent[x] = y;
            rank[y]++;
        } else {
            parent[y] = x;
            rank[x]++;
        }
        
    }

}
