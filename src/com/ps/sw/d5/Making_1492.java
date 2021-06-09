package com.ps.sw.d5;

import java.io.*;
import java.util.*;

public class Making_1492 {
	static int N, M;
	static int[] l, m, r;
	static long[] cnt;
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = stoi(br.readLine());
		for (int t=1; t<=T; t++) {
			long ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			
			l = new int[N];
			m = new int[N];
			r = new int[N];
			cnt = new long[N];
			Arrays.fill(cnt, 1);
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				l[i] = stoi(st.nextToken());
				m[i] = stoi(st.nextToken());
				r[i] = stoi(st.nextToken());
			}
			
			for (int i=0; i<M; i++) {
				long[] copy = cnt.clone();
				for (int j=0; j<N; j++) {
					if (j == 0) {
						cnt[j] += m[j]*copy[j];
						cnt[j+1] += r[j]*copy[j];
					} else if (j == N-1) {
						cnt[j-1] += l[j]*copy[j];
						cnt[j] += m[j]*copy[j];
					} else {
						cnt[j-1] += l[j]*copy[j];
						cnt[j] += m[j]*copy[j];
						cnt[j+1] += r[j]*copy[j];
					}
				}
				for (int j=0; j<N; j++) {
					cnt[j]%=1000000007;
				}
			}
			
			for (int j=0; j<N; j++) {
				ans += cnt[j];
			}
			sb.append("#").append(t).append(" ");
			sb.append(ans%1000000007).append("\n");
		}
		System.out.println(sb);

	}

}
