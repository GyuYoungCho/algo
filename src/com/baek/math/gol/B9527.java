package com.baek.math.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		System.out.println(one(M) - one(N-1));
	}
	
	static long one(long n) {
		long cnt=0, set= n, p=1;
		while(set>0) {
			cnt+=(n+1) / (p<<1) * p;
			if((set & 1) ==1) cnt+=(n+1)%p;
			set >>= 1;
			p <<= 1;
		}
		return cnt;
	}
	/* 1 4 12
	 * 1100
	 */
}
