package com.baek.brute.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14613 {
	static double W,L,D;
	static double[] arr = new double[5];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Double.parseDouble(st.nextToken());
		L = Double.parseDouble(st.nextToken());
		D = Double.parseDouble(st.nextToken());
		
		
		for (int win = 0; win <= 20; win++){
			for (int lose = 0; lose <= 20; lose++){
				for (int draw = 0; draw <= 20; draw++){
					
					if (win + lose + draw == 20){
						int score = 2000 + win * 50 - lose * 50;
						double pro = Math.pow(W, win * 1.0) * Math.pow(L, lose * 1.0) * Math.pow(D, draw * 1.0) * factorial(20)
							/ factorial(win) / factorial(draw) / factorial(lose);
						
						if (score >= 1000 && score <= 1499){
							arr[0] += pro;
						}else if (score >= 1500 && score <= 1999){
							arr[1] += pro;
						}else if (score >= 2000 && score <= 2499){
							arr[2]+= pro;
						}else if (score >= 2500 && score <= 2999){
							arr[3] += pro;
						}else if (score >= 3000 && score <= 3499){
							arr[4] += pro;
						}
					}
				}
			}
		}
		
		for(double x : arr) {
			sb.append(String.format("%.8f", x)).append("\n");
		}
		System.out.println(sb);
		
	}
	private static double factorial(int x)
	{
		if (x<=1) return 1.0;
		return x*factorial(x-1);
	}
}
