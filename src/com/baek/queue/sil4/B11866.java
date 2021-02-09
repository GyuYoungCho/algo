package com.baek.queue.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11866 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken())-1;
		int id = M;
		LinkedList<Integer> q = new LinkedList<>();
		sb.append("<");
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		while (q.size()!=1) {
			sb.append(q.get(id) + ", ");
			q.remove(id); 
			id = (id + M)%q.size();
		} 
		sb.append(q.poll().toString() + ">");
		System.out.println(sb);
	}

}
