package com.baek.imple.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Stack<Character> stack = new Stack<Character>();
		boolean in = false;
		String input = br.readLine();
		
		for(char ch : input.toCharArray()) {
			if(ch == '<') {
				in = true;
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append("<");
			} else if(ch == '>') {
				in = false;
				sb.append(">");
			} else if(ch == ' ') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(" ");
			} else {
				if(!in)
					stack.push(ch);
				else
					sb.append(ch);
			}
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb);
	}

}
