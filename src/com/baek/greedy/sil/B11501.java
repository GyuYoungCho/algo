package com.baek.greedy.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B11501 {
	static int T,N, prior;
	static long sum = 0;
	static int[] arr;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N-1;i++) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			sum = 0;
			int now = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				prior = stack.pop();
				now = Math.max(now,  prior);
				sum+= now - prior;
			}
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
