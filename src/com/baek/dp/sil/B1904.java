package com.baek.dp.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		for(int i=2;i<N;i++) {
			
			list.add((list.get(i-1)+list.get(i-2))%15746);
		}
		System.out.println(list.get(N-1));
	}

}
