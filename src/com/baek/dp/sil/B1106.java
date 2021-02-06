package com.baek.dp.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1106 {
	static int C,N;
	static int [] price,custom;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			price[i] = Integer.parseInt(st.nextToken());
			custom[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}

}
