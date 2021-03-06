package com.baek.math.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16464 {
	static int T,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			while(N!=1) {
				if(N%2==1) {
					sb.append("Gazua").append("\n");
					break;
				}
				N/=2;
			}
			if(N==1)
				sb.append("GoHanGang").append("\n");
		}
		System.out.println(sb);
	}

}
