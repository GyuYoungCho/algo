package com.baek.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991 {
	static class node{
		char no;
		node c1,c2;

		public node(char no) {
			this.no = no;
		}
	}
	
	static int T;
	static node [] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T ; t++) {
			st = new StringTokenizer(br.readLine());
			tree[t] = 
		}
		preorder(tree[0]);
		sb.append("\n");
		System.out.println(sb);
	}
	static void preorder(node num) {
		sb.append(tree[num].no);
		if(tree[num].c1 !='.') {
			return;
		}
		preorder(tree[num].c1 - 'A');
		if(tree[num].c2 !='.') {
			return;
		}
		preorder(tree[num].c2 - 'A');
	}
}
