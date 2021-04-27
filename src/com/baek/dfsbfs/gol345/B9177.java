package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9177 {
	static String a,b,c;
	static int N,as,bs,cs;
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			sb.append("Data set ").append(i).append(": ");
			st = new  StringTokenizer(br.readLine());
			a = st.nextToken();
			b = st.nextToken();
			c = st.nextToken();
			as = a.length();bs = b.length();cs=c.length();
			visit = new boolean[as+1][bs+1];
			sb.append(solve(0,0,0)?"yes":"no").append("\n");
		}
		System.out.println(sb);
	}
	private static boolean solve(int i, int j,int cnt) {
		
		if(cnt==cs) return true;
		
		if(visit[i][j]) return false;
		visit[i][j] = true;
		
		boolean flag = false;
		if(i<as && a.charAt(i)==c.charAt(cnt)) 
			flag|=solve(i+1,j,cnt+1);
		
		if(j<bs &&b.charAt(j)==c.charAt(cnt))
			flag|=solve(i,j+1,cnt+1);
		
		return flag;	
	}
}
