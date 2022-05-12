package com.baek.brute.sil;

import java.io.*;
import java.util.*;

public class B24954 {
	static int n, ans = Integer.MAX_VALUE;
	static int[] arr;
	static boolean[] visit;
	static List<List<int[]>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visit = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
		}
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	int m = Integer.parseInt(br.readLine());
        	List<int[]> item = new ArrayList<>();
        	for (int j = 0; j < m; j++) {
        		st = new StringTokenizer(br.readLine());
        		item.add(new int[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())});
        	}
        	list.add(item);
		}
        
        dfs(0, 0);
        
        System.out.println(ans);
	}

	static void dfs(int cost, int num) {
		
		for (int i = 0; i < n; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			cost += Math.max(arr[i], 1);
			if (num == n-1) {
				ans = Math.min(ans, cost);
			}
			
			for (int[] a: list.get(i)) {
				arr[a[0]] -= a[1];
			}
			
			dfs(cost, num + 1);
			
			for (int[] a: list.get(i)) {
				arr[a[0]] += a[1];
			}
			cost -= Math.max(arr[i], 1);
			visit[i] = false;
		}
	}

}
