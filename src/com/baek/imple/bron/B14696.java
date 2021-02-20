package com.baek.imple.bron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14696 {
	static int N, num1, num2;
	static int [] A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); 
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken()); 
			
			A = new int[5];
			for(int j=0;j<num1;j++) {
				A[Integer.parseInt(st.nextToken())]++; 
			}
			
			st = new StringTokenizer(br.readLine());
			num2 = Integer.parseInt(st.nextToken()); 
			
			B = new int[5];
			for(int j=0;j<num2;j++) {
				B[Integer.parseInt(st.nextToken())]++; 
			}
			
			boolean flag = false;
			for ( int j=4; j>0; j--) {
				if ( A[j] > B[j]) {
					sb.append("A").append("\n");
					break;
				}
				else if ( A[j] < B[j]){
					sb.append("B").append("\n");
					break;
				}
				if ( j==1 && A[j]==B[j]) flag = true;
				 
			}
			
			if ( flag) sb.append("D").append("\n");
		}
		System.out.println(sb);
	}

}
