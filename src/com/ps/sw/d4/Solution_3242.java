package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3242 {
	static int T,N,M;
	static int[] arr,rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
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
	            int d = Integer.parseInt(st.nextToken());
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            if(d==0) {
	            	union(a,b);
	            }else {
	            	sb.append(findSet(a)==findSet(b)?1:0);
	            }
	            
	        }
	        
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int findSet(int a) {
		if(arr[a]==a) return a;
		return arr[a] = findSet(arr[a]);
	}
	
	private static void union(int a, int b) {
		int aroot = findSet(a);
		int broot = findSet(b);
		if(aroot==broot) return;
		
		if(aroot>broot) arr[aroot] = broot;
		else arr[broot] = aroot;
	}
}
