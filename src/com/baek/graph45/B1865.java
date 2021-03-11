package com.baek.graph45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1865 {
	static int T, N, M, W, S,E,D, cnt = 0;
	static char a, b;
	static int[] parent;
	static boolean[] visited;
	static ArrayList<int[]>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                D = Integer.parseInt(st.nextToken());
                graph[S].add(new int[]{E,D});
                graph[E].add(new int[]{S,D});
			}
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                D = Integer.parseInt(st.nextToken());
                graph[S].add(new int[]{E,-D});
			}
			int root = 0;
			

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " is ");
				a = st.nextToken().charAt(0);
				b = st.nextToken().charAt(0);

			}
		}
	}

}
