package com.baek.imple.bron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2851 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max=0;
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+=Integer.parseInt(br.readLine());
			if(Math.abs(100-max) < Math.abs(100-sum)) break;
			max = sum;
		}
		System.out.println(max);
	}

}
