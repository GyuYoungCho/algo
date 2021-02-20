package com.baek.divide.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18291 {
	static int T,N;
	static final long m = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	    T = Integer.parseInt(br.readLine());
	    
	    for(int tc=0;tc<T;tc++) {
	    	N = Integer.parseInt(br.readLine());
	    	sb.append(N==1?1:divide(N-2)).append("\n");
	    }
	    System.out.println(sb);
	}
	private static long divide(int x) {
		if(x==0) return 1;
		long temp = divide(x/2);
		return temp*temp*(x%2+1)% m;
	}
}
