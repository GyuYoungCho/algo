package com.baek.disjoint;

import java.io.*;
import java.util.*;

public class B17490 {
	static int[] parent, arr;
	static boolean[] con;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
 
        parent = new int[N + 1];
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
        	parent[i] = i;
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
        con = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            con[b] = true;
        }

        for (int i = 1; i <= N; i++) {
        	int v = (i+1) % (N+1);
        	if(v==0) v=1;
        	if (find(i) !=find(v)) {
                if(con[v]) continue;
                union(i,v);
            }
        }
        
        long total=0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {
                total += arr[i];
                cnt++;
            }
        }
        
        System.out.println((total <= K || cnt <= 1)?"YES":"NO");
	}
	public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (arr[x] <= arr[y]) parent[y] = x;
        else parent[x] = y;
    }
}
