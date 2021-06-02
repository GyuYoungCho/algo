package com.baek.imple.gol45;

import java.io.*;
import java.util.*;

public class B10836 {
	
	static int M,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[] line = new int[2*M];
		while (N-->0)
	    {
			st = new StringTokenizer(br.readLine());
	        int zero, one;
	        zero = Integer.parseInt(st.nextToken());
	        one = Integer.parseInt(st.nextToken());
	        
	        for (int i = zero; i < zero + one; i++)
	            line[i]++;
	        for (int i = zero + one; i < 2*M - 1; i++)
	            line[i] += 2;
	    }
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				sb.append(j==0?line[M-i-1]+1:line[M+j-1]+1).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
