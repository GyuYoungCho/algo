package com.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
 
public class B9012 {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack;
		
		int T = Integer.parseInt(br.readLine());
		
		e:for(int i = 0; i < T; i++) {
			String s = br.readLine();
			stack = new Stack<>();
			for (int j = 0; j < s.length(); j++) {
				 
				char c = s.charAt(j);
	 
				if (c == '(') {
					stack.push(c);
				}
				else if (stack.empty()) {
					sb.append("NO").append('\n');
					continue e;
				}
				else{
					stack.pop();
				}
			}
	 
			if (stack.empty()) {
				sb.append("Yes").append('\n');
			} 
			else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb);
	}
}