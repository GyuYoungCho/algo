package com.baek.imple.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1052 {
	static int N, M,cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		while(true) {
			int k = N + cnt, one = 0;
			while(k!=0) {
				one+=k%2;
				k/=2;
			}
			if(one <= M) {
				break;
			}else cnt++;
		}
		System.out.println(cnt);
	}

}
