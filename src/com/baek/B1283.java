package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1283 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		StringBuilder sb1;

		int N = Integer.parseInt(br.readLine());
		String sentence, word;

		
		boolean[] isUse = new boolean[123];
		boolean findDan = false;

		for (int i = 0; i < N; i++) {
			findDan = false;
			sentence = br.readLine();
			sb1 = new StringBuilder();
			st = new StringTokenizer(sentence);
			
			while (st.hasMoreTokens()) {
				word = st.nextToken();
				if(!isUse[word.toLowerCase().charAt(0)] && !findDan) {
					isUse[word.toLowerCase().charAt(0)] = true;
					findDan = true;
					sb1.append("[").append(word.charAt(0)).append("]");
					for(int j=1;j<word.length();j++)
						sb1.append(word.charAt(j));
					sb1.append(" ");
				}else
					sb1.append(word + " ");
			}
			
			if(findDan) {
				sb.append(sb1).append("\n");	
			}else {
				for(int j=1;j<sentence.length();j++) {
					if(!isUse[sentence.toLowerCase().charAt(j)] && sentence.charAt(j) != ' ') {
						isUse[sentence.toLowerCase().charAt(j)] = true;
						sb1.insert(j, "[");
						sb1.insert(j+2, "]");
						sb.append(sb1).append("\n");
						findDan = true;
						break;
					}
				}
				if(!findDan) {
					sb.append(sb1).append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}
}
