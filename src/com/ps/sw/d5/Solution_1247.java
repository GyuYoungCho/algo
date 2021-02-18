package com.ps.sw.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247 {
	
	private static class Point {
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int T,N, dist, sum;
	static boolean visited[];
	static Point home, company;
	static Point[] custom;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			custom = new Point[N];
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			company = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			for (int i = 0; i < N; i++) {
				custom[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(custom, (o1,o2)-> o1.x - o2.x);
			dist = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				sum = 0;
				sum+=distance(company.x, custom[i].x, company.y, custom[i].y);
				visited[i] = true;
				dfs(0,sum, custom[i]);
				visited[i] = false;
			}
			
			sb.append("#").append(tc).append(" ").append(dist).append("\n");
			
		}
		System.out.println(sb);
	}
	private static void dfs(int cnt, int d, Point prior) {
		if(d > dist) return;
		if(cnt==N-1) {
			d+= distance(home.x,prior.x,home.y, prior.y);
			dist = Math.min(dist, d);
			
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1,d + distance(custom[i].x,prior.x,custom[i].y, prior.y), custom[i]);
				visited[i] = false;
			}
		}
	}
	private static int distance(int r1,int r2, int c1, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
	
	static String src= "10\r\n" + 
			"5\r\n" + 
			"0 0 100 100 70 40 30 10 10 5 90 70 50 20\r\n" + 
			"6\r\n" + 
			"88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14\r\n" + 
			"7\r\n" + 
			"22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83\r\n" + 
			"8\r\n" + 
			"30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63\r\n" + 
			"9\r\n" + 
			"3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92\r\n" + 
			"10\r\n" + 
			"39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36\r\n" + 
			"10\r\n" + 
			"26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96\r\n" + 
			"10\r\n" + 
			"46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63\r\n" + 
			"10\r\n" + 
			"94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3\r\n" + 
			"10\r\n" + 
			"32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86\r\n" + 
			"";
}
