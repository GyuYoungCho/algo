package com.baek.math.gol;

import java.io.*;
import java.util.*;

public class B9527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
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
	
}
