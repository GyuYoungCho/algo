package com.baek.divide.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629 {
	static int B;
	static long A,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		A%=C;
		System.out.println(pow(B));
	}
	private static long pow(int k) {
		if(k == 0) return 1;
		 
	    long temp = pow(k/2);
	    long result = temp * temp % C;
	    if(k%2==1) result = result * A % C;
	    return result;
	}
}