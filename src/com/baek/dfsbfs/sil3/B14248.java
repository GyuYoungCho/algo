package com.baek.dfsbfs.sil3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14248 {

	static int T,N,cnt=1;
	static int[] map;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		map = new int[T];
		visited = new boolean[T];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<T;i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		N = Integer.parseInt(br.readLine());
		jump(N-1);
		System.out.println(cnt);
	}
	
	static void jump(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(inside(now+map[now])&&!visited[now+map[now]]) {
				visited[now+map[now]] = true;
				cnt++;
				q.add(now+map[now]);
			}if(inside(now-map[now])&&!visited[now-map[now]]) {
				visited[now-map[now]] = true;
				cnt++;
				q.add(now-map[now]);
			}
		}
	}
	static boolean inside(int x) {
		return x>=0 && x<T;
	}
}
