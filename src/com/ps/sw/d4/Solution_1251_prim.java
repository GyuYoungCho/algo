package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_prim {

	static int T, N;
	static long[][] arr;
	static int[] x, y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			x = new int[N];
			y = new int[N];
			arr = new long[N][N];
			for (int j = 0; j < N; j++) {
				x[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				y[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[j][i] = arr[i][j] = getDistance(x[i],x[j],y[i],y[j]); 
				}
			}
			double E = Double.parseDouble(br.readLine());
			sb.append(Math.round(makeMST()*E)).append("\n");
		}
		System.out.println(sb);
	}
	
	private static long makeMST() {
		long[] minedge = new long[N];
		boolean[] visit = new boolean[N];
		
		Arrays.fill(minedge, Integer.MAX_VALUE);
		
		// 임의 점 시작
		minedge[0] = 0;
		
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.offer(new Vertex(0, minedge[0]));
		
		long result = 0; //비용
		int cnt = 0; // 정점 개수
		
		while(true) {
			Vertex minver = q.poll();
			if(visit[minver.no]) continue;
			
			//  신장 트리 포함
			visit[minver.no] = true;
			result+=minver.cost;
			if(++cnt == N) break;
			
			for (int i = 0; i < N; i++) {
				// 연결성 여부 확인
				// arr[minno][i] !=0 -> 조건 생략 해도 됨
				if(!visit[i] && minedge[i] > arr[minver.no][i]) {
					minedge[i] = arr[minver.no][i];
					q.offer(new Vertex(i, minedge[i]));
				}
			}
		}
		
		return result;
	}

	private static long getDistance(int x1, int x2, int y1, int y2) {
		return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}

	public static boolean inside(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		long cost;
		
		public Vertex(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}


		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.cost, o.cost);
		}
		
	}
	
}
