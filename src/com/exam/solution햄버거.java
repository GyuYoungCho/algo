package com.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution햄버거 {
	
	static int T,N,L;
	static Material[] ms;
	static int MAX_SAT;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			ms = new Material[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int T = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken()); 
                ms[i] = new Material(T,K);
			}
			MAX_SAT=0;
			subset(N,0,0);
			sb.append("#").append(tc).append(" ").append(MAX_SAT).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void subset(int tochoose, int sat, int cal) {
		if(cal>L)
			return;
		if(tochoose==0) {
			MAX_SAT = Math.max(MAX_SAT, sat);
			return;
		}
		
		int idx = N-tochoose;
		// 기존 만족도 + 새로운 만족도
		subset(tochoose-1,sat+ms[idx].sat,cal + ms[idx].cal);
		subset(tochoose-1,sat,cal);
	}
	static class Material{
		int sat,cal;

		public Material(int sat, int cal) {
			this.sat = sat;
			this.cal = cal;
		}
		
	}
}
