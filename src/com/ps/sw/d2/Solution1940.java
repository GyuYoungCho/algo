package com.ps.sw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1940 {
	static int T,N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int vel = 0, dis = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				String k =st.nextToken();
				
				if(k.equals("1")) {
					vel+=Integer.parseInt(st.nextToken());
				}else if(k.equals("2")) {
					int min = Integer.parseInt(st.nextToken());
					vel = vel <= min ? 0 : vel-min;
				}
				dis+=vel;	
			}
			
			sb.append("#").append(t).append(" ").append(dis).append("\n");
		}
		System.out.println(sb);
	}

}
