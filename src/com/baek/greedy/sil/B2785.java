package com.baek.greedy.sil;

import java.io.*;
import java.util.*;

public class B2785 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		
		int ans = 0;
		
		while(list.size() > 1) {
			list.set(0,  list.get(0)-1);
			list.remove(list.size()-1);
			if(list.get(0) == 0)list.remove(0);
			ans++;
		}
		System.out.println(ans);
	}

}
