package com.baek.brute.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18119 {
	static int N, M, cnt;
	static char[] idx = new char[2];
	static int[] bit;
	static int alpha = (1 << 27) - 1;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		bit = new int[N];

		while (N-- > 0) {
			s = br.readLine();
			for (char c : s.toCharArray()) {
				bit[N] |= 1 << (c - 'a');
			}
		}
		
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			char o = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			if(o=='1') {
				alpha &= ~(1 << (c -'a'));
			}else {
				alpha |= (1<<(c -'a'));
			}
//			System.out.println(Integer.toBinaryString(alpha));
			cnt = 0;
			for(int i : bit) {
				if((alpha & i) >= i) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
