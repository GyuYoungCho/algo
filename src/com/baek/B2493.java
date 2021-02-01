package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int [] top = new int[N];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<N;i++)
			top[i] = Integer.parseInt(st.nextToken());
		
		e:for(int i=N-1;i>0;i--) {
			for(int j=i-1;j>=0;j--) {
				if (top[i] < top[j]) {
					stack.push(j+1);
					continue e;
				}
			}
			stack.push(0);
		}
		stack.push(0);
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		
		System.out.println(sb);
	}

}
