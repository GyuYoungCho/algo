package com.baek.imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3985 {
	static int N,M,P,K,max_idx,exp_idx, cnt, max = 0,expect = 0;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visit = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt=0;
			if(expect < K-P) {
				expect = K-P;
				exp_idx = i+1;
			}
			for(int j=P;j<=K;j++) {
				if(!visit[j]) {
					visit[j] =true;
					cnt++;
				}
			}
			if(max<cnt) {
				max = cnt;
				max_idx = i+1;
			}
		}
		sb.append(exp_idx).append("\n").append(max_idx);
		System.out.println(sb);
	}

}
