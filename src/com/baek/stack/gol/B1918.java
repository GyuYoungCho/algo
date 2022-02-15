package com.baek.stack.gol;

import java.io.*;
import java.util.*;

public class B1918 {
	
	static int preced(char ch) {
        if (ch == '(') return 0;
        if (ch == '+' || ch == '-') return 1;
        else return 2;
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        
        for (char ch : str.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                sb.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty()) {
                    char op = stack.pop();
                    if (op == '(') break;
                    sb.append(op);
                }
            } else {
                while (!stack.isEmpty() && preced(stack.peek()) >= preced(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
	}
}
