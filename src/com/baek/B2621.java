package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2621 {
	
	public static int[] color, digit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		color = new int[4];
		digit = new int[10];
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			char C = st.nextToken().charAt(0);
			int d = Integer.parseInt(st.nextToken());
			
			
		}
	}
}
