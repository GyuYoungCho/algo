package com.baek.greedy.gol;

import java.io.*;
import java.util.*;

public class B2109 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->
			o2[0]-o1[0]
		);
		int max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			max = Math.max(d, max);
			pq.add(new int[] {p, d});
		}
		
		boolean[] visit = new boolean[max+1];
		int sum = 0;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			for(int i = cur[1]; i >= 1; i--) {
				if(!visit[i]) {
					visit[i] = true;
					sum += cur[0];
					break;
				}
			}
		}
		System.out.println(sum);
	}

}
