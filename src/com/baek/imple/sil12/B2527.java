package com.baek.imple.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2527 {
	static int[] A = new int[4], B = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=0;j<4;j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(values()).append("\n");
		}
		System.out.println(sb);
	}

	private static String values() {
		if(A[0] > B[2] || A[1] > B[3] || A[2] < B[0] || A[3] < B[1] ) {
			return "d";
		}
		else if((A[0] == B[2] &&A[1] == B[3]) || (A[0] == B[2] &&A[3] == B[1]) ||
				(A[2] == B[0] &&A[3] == B[1]) ||(A[2] == B[0] &&A[1] == B[3])) {
			return "c";
		}else if(A[0] == B[2] || A[1] == B[3] || A[2] == B[0] || A[3] == B[1]){
			return "b";
		}else{
			return "a";
		}
	}

}
