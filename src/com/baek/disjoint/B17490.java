package com.baek.disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B17490 {
	static int[] parent, arr;
	static boolean[] con;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        if(M<2) {
        	System.out.println("Yes");return;
        }
 
        parent = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        PriorityQueue<int []> pq = new PriorityQueue<>(
        		(o1, o2) -> Integer.compare(o1[0], o2[0])
        		);
        
        for (int i = 1; i <= N; i++) {
        	parent[i] = i;
			pq.add(new int[] {Integer.parseInt(st.nextToken()),i});
		}
        
        
        con = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            if (max==min+1) {
                con[min] = true;
            } else{
            	con[max] = true;
            }
        }
        
        int cnt=0;
        for (int i = 1; i <= N; i++) {
        	if (!con[i]) {
                int k =i==N?union(i, 1):union(i, i+1);
                cnt++;
            }
        }
        
        long total=0;
        while(!pq.isEmpty()) {
        	if (cnt == N || total >= K) {
                break;
            }
        	
        	int cur[] = pq.poll();
        	
        	if (find(cur[1]) != find(0)) {
                total += cur[0];
                cnt++;
                union(cur[1], 0);
            }
        	System.out.println(cur[0]);
        }
        
        System.out.println((cnt == N || total >= K)?"YES":"NO");
	}
	public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
 
        return parent[x] = find(parent[x]);
    }
 
    public static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x==y) return 0;
        
        if (x>y) parent[x] = y;
        else parent[y] = x;
        return 0;
    }
}
