package com.baek.imple.bron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10163 {
	private static class AllPoint{
		int x,y,z,w;

		public AllPoint(int x, int y, int z, int w) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.w = w;
		}
		
	}
	static int N;
	static int[][] map;
	static Stack<AllPoint> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); 
		StringTokenizer st;
		
		int map[][] = new int[101][101]; 
		for (int i = 1; i <= N; i++) { 
			st = new StringTokenizer(br.readLine()); 
			int x1 = Integer.parseInt(st.nextToken()); 
			int y1 = Integer.parseInt(st.nextToken()); 
			int x2 = Integer.parseInt(st.nextToken()); 
			int y2 = Integer.parseInt(st.nextToken()); 
			
			stack.add(new AllPoint(x1, y1, x2, y2));
		
		while(!stack.isEmpty()) {
			
			sb.append(cnt).append("\n");
		}
			
		System.out.println(sb);
	}

}
