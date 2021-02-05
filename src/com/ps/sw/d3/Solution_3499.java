package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_3499 {
	static int N,T;
	static String[] input1,input2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			
			input1 = (N%2==0)?new String[N/2] : new String[N/2+1];
			input2 = new String[N/2];
			
			for (int i = 0; i < input1.length; i++) {
				input1[i] = st.nextToken();
			}
			for (int i = 0; i < input2.length; i++) {
				input2[i] = st.nextToken();
			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < input2.length; i++) {
				sb.append(input1[i]).append(" ");
				sb.append(input2[i]).append(" ");
			}
			if (N%2==1)
				sb.append(input1[N/2]);
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
	static String src ="3\r\n" + 
			"6\r\n" + 
			"A B C D E F\r\n" + 
			"4\r\n" + 
			"JACK QUEEN KING ACE\r\n" + 
			"5\r\n" + 
			"ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";

}
