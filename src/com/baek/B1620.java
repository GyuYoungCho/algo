package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1620 {

	static int N,M;
	static String pocket, question;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> stoi = new HashMap<String, Integer>();
		Map<Integer,String> itos = new HashMap<Integer, String>();
		
		for (int i=1;i<=N;i++) {
			pocket = br.readLine();
			stoi.put(pocket, i);
			itos.put(i, pocket);
		}
		
		for (int i=0;i<M;i++) {
			question = br.readLine();
			if(question.charAt(0)>'0' && question.charAt(0)<='9')
				sb.append(itos.get(Integer.parseInt(question))).append("\n");
			else
				sb.append(stoi.get(question)).append("\n");
		}
		System.out.println(sb);
	}

}
