package com.baek.math.bron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B3052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> s = new HashSet<>();
		for(int i=0;i<10;i++) {
			s.add(Integer.parseInt(br.readLine())%42);
		}
		System.out.println(s.size());
	}

}
