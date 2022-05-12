package com.baek.string.gol;

import java.io.*;

public class B24956 {
	static long w,h,e,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int mod = 1000000007;
		char[] arr = br.readLine().toCharArray();
		
		for(char a : arr) {
			if(a=='W') w+=1;
			else if(a=='H') h+=w;
			else if(a=='E') {
				ans = (2*ans + e)%mod;
				e+=h;
			}
		}
		
		System.out.println(ans);
	}

}
