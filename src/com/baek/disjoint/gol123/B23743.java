package com.baek.disjoint.gol123;

import java.io.*;
import java.util.*;

public class B23743 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
        parent = new int[N+1];

        ArrayList<int[]> edges = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[] {a, b, c});
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            parent[i] = i;
            edges.add(new int[] {0, i, Integer.parseInt(st.nextToken())});
        }

        Collections.sort(edges,(o1,o2)-> Integer.compare(o1[2], o2[2]));
        int ans = 0;
        for(int[] e:edges){
            if(find(e[0]) != find(e[1])){
                ans += e[2];
                union(e[0], e[1]);
            }
        }
        System.out.println(ans);
	}
	
	public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x <= y) parent[y] = x;
        else parent[x] = y;
    }
}
