package com.baek.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int id=1;
		while(true) {
			
			char[] s = br.readLine().toCharArray();
			if(s[0]=='-') break;
			int cnt=0;
			Stack<Character> tak = new Stack<>();
			for(char k : s) {
				if(k=='}') {
					if(tak.isEmpty()) {
						cnt++;
						tak.add('{');
					}
					else tak.pop();
				}
				else tak.add('{');
			}
			if(!tak.isEmpty())
			cnt+=tak.size()/2;
			
			sb.append(id++).append(". ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
