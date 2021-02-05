package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1223 {
	static int N, Answer;
	static char [] cal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			cal = new char[N];
			cal = br.readLine().toCharArray();
			Answer = 0;
			
			for(int i=0;i<N;i++) {
				switch(cal[i]) {
                case '*':
                    stack.push(stack.pop()*(cal[++i]-'0'));
                    break;                  
                case '+':
                    break;
                default:
                    stack.push(cal[i]-'0');
                }
			}
			while(!stack.isEmpty()) {
				Answer+=stack.pop();
			}
			
			sb.append("#").append(tc).append(" ").append(Answer).append("\n");
		}
		System.out.println(sb);
	}

}
