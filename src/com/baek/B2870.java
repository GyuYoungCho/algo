package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class B2870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		 
		String[] arr1 = new String[N];
		ArrayList<BigInteger> list = new ArrayList<>();
 
		for (int i = 0; i < N; i++) {
			arr1[i] = br.readLine();
		}
		
		boolean num;
		int start;
		
		for (int i = 0; i < N; i++) {
			num = false;
			start = 0;
			for (int j = 0; j < arr1[i].length(); j++) {
				if (!num && arr1[i].charAt(j) > 47 && arr1[i].charAt(j) < 58) {
					num = true;
					start = j;
				}else if(num && (arr1[i].charAt(j) <= 47 || arr1[i].charAt(j) >= 58)) {
					list.add(new BigInteger(arr1[i].substring(start,j)));
					num = false;
				}
			}
			if(num)
				list.add(new BigInteger(arr1[i].substring(start,arr1[i].length())));
		}
		
		Collections.sort(list);
		
		for(BigInteger b : list)
			sb.append(b + "\n");
		System.out.println(sb);
	}

}
