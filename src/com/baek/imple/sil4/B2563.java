package com.baek.imple.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563 {
	static int T,N,M, cnt=0;
	static boolean field[][] = new boolean[100][100]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken());
			
			for(int i=N;i<N+10;i++) {
				for(int j=M;j<M+10;j++) {
					if(!field[i][j]) {
						field[i][j] = true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
