package com.baek.string.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1593 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[] W = br.readLine().toCharArray();
		char[] S = br.readLine().toCharArray();
		
		int[] wAlpha = new int[58];
		for(int i=0; i<n; i++) {
			wAlpha[W[i]-'A']++;
		}
		
		int[] sAlpha = new int[58];
		int next, len=0, answer=0, from=0;
		for(int i=0; i<m; i++) {
			next = S[i]-'A';
			len++;
			sAlpha[next]++;
			if(len==n) {
				if(same(wAlpha, sAlpha)) answer++;
				
				sAlpha[S[from]-'A']--;
				from++; 
				len--;
			}
		}
		System.out.print(answer);
	}
	static boolean same(int[] w, int[] s) {
		for(int i=0; i<58; i++)
			if(w[i]!=s[i]) return false;
		return true;
	}
}
