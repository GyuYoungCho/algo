package com.baek.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1062 {
	static int N,M, cnt=0;
	static int alpha;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(M<5) System.out.println(0);
		else if(M==26) System.out.println(N);
		
		else {
			M-=5;
			e:for(int i=0;i<N;i++) {
				String s = br.readLine();
				s = s.substring(4,s.length()-4);
				int bit = 0, count=0;
				bit |= 1 << 0;bit |= 1 << 2;bit |= 1 << 8;bit |= 1 << 13;bit |= 1 << 19;
				for(int j=0;j<s.length();j++) {
					char c = s.charAt(j);
					int a = 1 << (c-'a');
					if((bit & a)!=a) {
						bit |= a;
						count++;
					}
				}
				if(count <= M) cnt++;
			}
			System.out.println(cnt);
		}
	}

}
