package com.baek.graph45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1865 {
	static int N,M, cnt=0;
	static char a,b;
	static int[] parent;
	static boolean [] visited;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	    N = Integer.parseInt(br.readLine());
	    graph = new ArrayList[26];
	    visited = new boolean[26];	    
	    for (int i = 0; i < 26; i++) {
	        graph[i] = new ArrayList<Integer>();
	    }
	    int root = 0;
	    for (int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine()," is ");
	        a = st.nextToken().charAt(0);
	        b = st.nextToken().charAt(0);
	        graph[a-'a'].add(b-'a');
	    }
	    
	    for (int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine()," is ");
	        a = st.nextToken().charAt(0);
	        b = st.nextToken().charAt(0);
	        
	    }
	}

}
