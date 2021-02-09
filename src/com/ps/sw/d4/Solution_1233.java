package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233 {
	
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			boolean is = true;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				if(N/2<i) {
					st.nextToken();
					char k = st.nextToken().charAt(0);
					if(k=='+'||k=='-'||k=='*'||k=='/') {
						is = false;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(is?1:0).append("\n");
		}
		System.out.println(sb);
	}

}
