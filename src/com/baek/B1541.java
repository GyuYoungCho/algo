package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer minus = new StringTokenizer(br.readLine(),"-");
		
		StringTokenizer first = new StringTokenizer(minus.nextToken(),"+");
		int sum = 0;
		while (first.hasMoreTokens()) {
			sum += Integer.parseInt(first.nextToken());
		}
		
		while (minus.hasMoreTokens()) {
			int temp = 0;
			StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
			
			while (plus.hasMoreTokens()) {
				temp += Integer.parseInt(plus.nextToken());
			}
			sum -= temp;
		}
		System.out.println(sum);
	}

}
