package com.baek.bit.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17453 {
	static int N,M;
	static int door[], switches[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		door = new int[N];
		switches = new int[M][N];
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			if(str.charAt(i)=='1') door[i] = 1;
			else door[i]=-1;
		}
		
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				if(str.charAt(j)=='1') door[i] = 1;
				else door[i]=-1;
			}
		}
		
		
	}

}
