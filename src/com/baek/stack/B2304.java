package com.baek.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int top = 0;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		for(int i=1;i<=N;i++) {
			top = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek() >= top) {
					sb.append(index.peek()).append(" ");
					break;
				}
				stack.pop();
				index.pop();
			}
			if (stack.isEmpty())
				sb.append(0).append(" ");
			stack.push(top);
			index.push(i);
		}
		
		System.out.println(sb);
	}

}
