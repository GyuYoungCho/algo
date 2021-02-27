package com.baek.backtrack.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182_1 {
	static int [] input;
	static int N, sum, Answer, count;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());
		
			
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		isSelected = new boolean[N];
		for(int i=0;i<N;i++) {
			input[i] =  Integer.parseInt(st.nextToken());
		}
		
		if(sum==0)
			Answer--;
		generateSubset(0,0);
		
		System.out.println(count);
	}
	
	static void generateSubset(int cnt, int s) {
		if(cnt == N)
			return;
		
		if(s+ input[cnt]==sum) {
			count++;
		}
		generateSubset(cnt+1,s);
		generateSubset(cnt+1,s + input[cnt]);
		
	}
}
