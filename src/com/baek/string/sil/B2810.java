package com.baek.string.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2810 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=1;
	
		String k = br.readLine();
		k =k.replace("LL", "S");
		if(N>=k.length()+1)
			System.out.println(k.length()+1);
		else
			System.out.println(N);
	
	}
}
