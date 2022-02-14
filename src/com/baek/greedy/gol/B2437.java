package com.baek.greedy.gol;

import java.io.*;
import java.util.*;

public class B2437 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr.add(Integer.parseInt(st.nextToken()));
			
		Collections.sort(arr);
		int sum = 1;
		for (int j = 0; j < N; j++) {
			int a = arr.get(j);
			if(sum < a) break;
			sum+=a;
		}
		System.out.println(sum);
	}
}
