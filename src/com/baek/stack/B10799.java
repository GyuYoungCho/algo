package com.baek.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int bar = 0;
		int Answer = 0;
		String str = br.readLine();
		str = str.replace("()", "c");
		for(int i=0;i < str.length();i++) {
			if (str.charAt(i) == '(') {
				bar+=1;
			}else if(str.charAt(i) == ')') {
				bar-=1;
				Answer+=1;
			} else {
				Answer+=bar;
			}
		}
		System.out.println(Answer);
	}
}
