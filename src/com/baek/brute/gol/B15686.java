package com.baek.brute.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686 {
	private static class Point{
		int r,c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N, M, num, chick_len, final_dist = Integer.MAX_VALUE;
	static boolean[] check;
	static ArrayList<Point> house = new ArrayList<>();;
	static ArrayList<Point> chick = new ArrayList<>();;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				num = Integer.parseInt(st.nextToken());
				if(num==1) house.add(new Point(i,j));
				else if(num==2) chick.add(new Point(i,j));
			}
		}
		chick_len = chick.size();
		check = new boolean[chick_len];
		
		search(0,0);
		System.out.println(final_dist);
	}

	public static void search(int cnt, int start) { 
		if (cnt == M) { 
			int dist, sum=0;
			for(Point h : house) {
				int min=2*N;
				for(int i=0;i<chick_len;i++) {
					if(check[i]) {
						dist = Math.abs(h.r - chick.get(i).r) + Math.abs(h.c - chick.get(i).c);
						min = Math.min(dist, min);
					}
				}
				sum+=min;
			}
			final_dist = Math.min(final_dist, sum);
			return; 
		} 
		
		for (int i = start; i < chick_len; i++) {
			check[i] = true;
			search(cnt + 1, i + 1); 
			check[i] = false; 
		} 
	}
}
