package com.baek.math.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1016 {
	static long N,M, cnt;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken()); 
		M = Long.parseLong(st.nextToken());
		
		check = new boolean[(int)(M-N+1)];
		for(long i=2; i<=(int)Math.sqrt(M); i++) {
			long start = ((N -1)/(i*i)+1)*(i*i);
			for(long j=start; j<=M; j+=(i*i)) {
				check[(int)(j-N)] = true;
			}
		}
		cnt = 0;
		for(int i=0; i<=M-N; i++) {
			if(!check[i]) cnt++;
		}
		System.out.println(cnt);
	}

}
