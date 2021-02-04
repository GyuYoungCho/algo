package com.baek.brute.bron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class B2798 {
	
	static int N,M, min;
	static int [] input;
	static int [] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sum = new int[3];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		min = -100000000;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i]= Integer.parseInt(st.nextToken());
		}
		black(0,0);
		System.out.println(min);
	}
	
	static void black(int cnt,int start) {
		if(cnt==3) {
			int total = 0;
			for(int i=0;i<3;i++) {
				total+=sum[i];
			}
			if(M == total) {
				min = total;
				return;
			}
			if(total <= M && total > min)
				min = total;
			return;
		}
		
		for(int i = start;i<N;i++) {
			sum[cnt] = input[i];
			black(cnt+1,i+1);
		}
	}

}
