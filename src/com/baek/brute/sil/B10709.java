package com.baek.brute.sil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10709 {
	static char[] field;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new char[M];

		boolean atcloud;
		for (int i = 0; i < N; i++) {
			field = br.readLine().toCharArray();
			atcloud = false;
			int cnt = 0;
			for (int j = 0; j < M; j++) {
				if (field[j] == 'c') {
					atcloud = true;
					cnt = 0;
					sb.append(cnt).append(" ");
				} else if (!atcloud)
					sb.append(-1).append(" ");
				else {
					sb.append(++cnt).append(" ");
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
