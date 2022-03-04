package com.baek.map;

import java.io.*;
import java.util.*;

public class B2002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> car = new HashMap<>();
		for(int i = 0; i<N;i++) {
			car.put(br.readLine(), i);
		}
		
		int cnt = 0;
		boolean[] isOut = new boolean[N];
		for(int i = 0; i<N;i++) {
			int num = car.get(br.readLine());
			for(int j = 0; j<num;j++) {
				if(!isOut[j]) {
					cnt++;
					break;
				}
			}
			isOut[num] = true;
		}
		System.out.println(cnt);
	}

}
