package com.saffy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1863 {

	static int N,M, cnt;
	static int[] arr,rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr= new int[N+1];
		rank= new int[N+1];
		for (int i = 1; i <= N; i++) { 
			arr[i] = i; 
		}

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        for (int i = 1; i <= N; i++) { 
			if(i==arr[i]) cnt++;
		} 
		System.out.println(cnt);
	}

	private static int findSet(int a) {
		if(arr[a]==a) return a;
		return arr[a] = findSet(arr[a]);
	}
	
	private static void union(int a, int b) {
		int aroot = findSet(a);
		int broot = findSet(b);
		
		if(rank[aroot] < rank[broot])
			arr[aroot] = broot;
		else {
			arr[broot] = aroot;
			if(rank[aroot]==rank[broot]) rank[aroot]++;
		}
	}

}
