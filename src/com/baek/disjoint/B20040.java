package com.baek.disjoint;

import java.io.*;
import java.util.*;

public class B20040 {
	static int[] parent, arr;
	static boolean[] con;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		
		for (int i = 1; i < N; i++) {
			parent[i] = i;
		}
		int ans=0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a)!=find(b)) union(a,b);
			else {
				ans = i+1;
				break;
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
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
}
