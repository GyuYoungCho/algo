package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251 {
	static int T, N;
	static int[][] arr;
	static int[] get, rank;
	
	static class Node{
		int x,y;
		double cost;

		public Node(int x, int y, double cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			get = new int[N];
			rank = new int[N];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			double E = Double.parseDouble(br.readLine());
			for (int j = 0; j < N; j++) {
				get[j] = j;
			}
			
			PriorityQueue<Node> pq =new PriorityQueue<>((o1, o2) -> Double.compare(o1.cost, o2.cost));
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					double dist = Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2);
					pq.offer(new Node(i,j,dist));
				}
			}
			
			double total = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				int x = findSet(cur.x);
				int y = findSet(cur.y);
				if (x == y)
					continue;
				union(x, y);
				total += cur.cost;
			}
			
			sb.append(Math.round(total*E)).append("\n");
		}
		
		System.out.println(sb);
	}
	private static int findSet(int a) {
		if(get[a]==a) return a;
		return get[a] = findSet(get[a]);
	}
	
	private static void union(int a, int b) {
		int aroot = findSet(a);
		int broot = findSet(b);
		if(rank[aroot] < rank[broot])
			get[aroot] = broot;
		else {
			get[broot] = aroot;
			if(rank[aroot]==rank[broot]) rank[aroot]++;
		}
	}
	
	public static boolean inside(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
	
}
