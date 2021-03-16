package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B121 {
	static int K,P,N;
	static int C = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

	    K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		System.out.println(K*pow(N)%C);
	}
	private static long pow(int k) {
		if(k == 0) return 1;
	    long temp = pow(k>>1);
	    long result = temp * temp % C;
	    if(k%2==1) result = result * P % C;
	    return result;
	}
}
