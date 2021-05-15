package com.baek.greedy.gol;

import java.io.*;
import java.util.*;

public class B17828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		if(N>X|| N*26<X) {
			System.out.println("!");
			return;
		}
		for (int i = 0; i < N; i++) {
			sb.append("A");
		}
		X-=N;
		N--;
		while(X > 0) {
	        if(X >= 25) {
	        	sb.setCharAt(N, 'Z');
	            N--;
	            X -= 25;
	        }
	        else {
	        	sb.setCharAt(N, (char)(X + 65));
	            break;
	        }
		}
		System.out.println(sb);
	}
}
