package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_2805 {

	static int N, num, sum;
	static char[][] field;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int sum = 0;
			field = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				field[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for(int j=Math.abs(N/2-i); j<N-Math.abs(N/2-i); j++) {
					sum += field[i][j] - '0';
				}
//				if(i<N/2) {
//					for(int j=N/2-i; j<=N/2+i; j++) {
//						sum += field[i][j] - '0';
//					}
//				} else {
//					for(int j=i-N/2; j<N*3/2-i; j++) {
//						sum += field[i][j] - '0';
//					}
//				}
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	static String src = "1\r\n" + "5\r\n" + "14054\r\n" + "44250\r\n" + "02032\r\n" + "51204\r\n" + "52212";
}
