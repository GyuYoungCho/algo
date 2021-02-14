package com.baek.tree.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068 {
	static int N,P,D, cnt=0;
	static int[] parent;
	static boolean [] visited;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    N = Integer.parseInt(br.readLine());
	    tree = new ArrayList[N];
	    visited = new boolean[N];
	    StringTokenizer st = new StringTokenizer(br.readLine());	    
	    for (int i = 0; i < N; i++) {
	        tree[i] = new ArrayList<Integer>();
	    }
	    int root = 0;
	    for (int i = 0; i < N; i++) {
	        P = Integer.parseInt(st.nextToken());
	        if (P == -1) {
	            root = i;
	            continue;
	        }
	        tree[P].add(i);
	        tree[i].add(P);
	    }
	    D = Integer.parseInt(br.readLine());
	    if(root==D) {
	    	System.out.println(0);
	    	return;
	    }
	    search(root);
	    System.out.println(cnt);
	}
	static void search(int num) {
		visited[num] = true;
		int child = 0;
		for( int i = 0 ; i < tree[num].size() ; i++ ) {
			int son = tree[num].get(i);
			if(!visited[son] && son != D) {
				child++;
				search(son);
			}
		}
		if(child==0) {
			cnt++;
		}
	}
	
}
