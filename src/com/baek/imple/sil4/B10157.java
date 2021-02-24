package com.baek.imple.sil4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10157 {
	static int N,M,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		if(K>M*N) {
			System.out.println(0);return;
		}
		int idx = 1;
		while(true) {
			if(K <= 2*(M +N) -4) break;
			K-= (2*(M +N) -4);
			idx++;
			M-=2;N-=2;
		}
		
		
		int x=-1,y=0;
		e:while(true) {
			for(int i=0;i<M;i++) {
				x++;
				if(--K ==0) break e;
			}
			for(int i=0;i<N-1;i++) {
				y++;
				if(--K ==0) break e;
			}
			for(int i=0;i<M-1;i++) {
				x--;
				if(--K ==0) break e;
			}
			
			for(int i=0;i<N-1;i++) {
				y--;
				if(--K ==0) break e;
			}
			
			break e;
		}
		sb.append((idx + y) + " " + (idx + x));
		System.out.println(sb);
	}

}
