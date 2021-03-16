package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1238 {
	static int N,K;
	static int arr[][];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N+1][N+1];
			visit = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N/2 ; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
			visit = new boolean[N+1];
			List<Integer> list = new ArrayList<Integer>();
			
			int ans = K;
			queue.add(K);
			visit[K] = true;
			int idx = 0;
			
			while(true) {
				boolean flag = false;

				while(!queue.isEmpty()) {
					list.add(queue.poll());
				}
				
				int l = list.size();
				
				for(int j = idx ; j < l ; j++) {
					for(int i = 1 ; i <= N ; i++) {
						if(arr[list.get(j)][i] == 1 && !visit[i]) {
							flag = true;
							queue.add(i);
							visit[i] = true;
						}
					}
				}
				idx = l;
				if(!flag) {
					ans = list.get(list.size()-1);
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	

}
