package com.baek.tree.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725 {

	static ArrayList<Integer>[] tree;
	static boolean[] isVisited;
	static int[] returnArr;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N= Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];
		returnArr = new int[N+1];
		
		for( int i = 1 ; i <= N ; i++ ) {
			tree[i] = new ArrayList<Integer> ();
			isVisited[i] = false;
		}
		
		for( int i = 0 ; i < N-1 ; i++ ) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		DFS(1);

		for( int i = 2 ; i <= N ; i++ ) {
			sb.append(returnArr[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void DFS(int node) {
		isVisited[node] = true;
		for( int i = 0 ; i < tree[node].size() ; i++ ) {
			int adjNode = tree[node].get(i);
			if( isVisited[adjNode] == false ) {
				returnArr[adjNode] = node;
				DFS(adjNode);
			}
		}
	}

}
