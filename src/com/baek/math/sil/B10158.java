package com.baek.math.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10158 {
	static int N,M, r,c, dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dist = Integer.parseInt(br.readLine());
		
		System.out.println((N - Math.abs(N- (r+dist)%(N*2))) +" " 
					+ (M - Math.abs(M -(c+dist)%(M*2))));
	}

}
