package com.baek.dfsbfs.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15558 {
	static int N,K;
	static char arr[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new char[2][N];
        visit = new boolean[2][N];
        arr[0] = br.readLine().toCharArray();
        arr[1] = br.readLine().toCharArray();
        
	}
	private static void bfs() {
		
	}
}
