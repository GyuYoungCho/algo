package com.baek.greedy.gol;

import java.io.*;
import java.util.*;

public class B1461 {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		
		ArrayList<Integer> minus = new ArrayList<>();
		ArrayList<Integer> plus = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = stoi(st.nextToken());
			if (cur < 0) minus.add(cur);
			else plus.add(cur);
		}
		Collections.sort(minus);
		Collections.sort(plus,(o1,o2)->o2-o1);
		int ans = 0;
		int max = 0;
		for (int i = 0; i < minus.size(); i += M) {
			int now = minus.get(i) * -1;
			if (now > max) max = now;
			ans += now*2;
		}
		for (int i = 0; i < plus.size(); i += M) {
			int now = plus.get(i);
			if (now > max) max = now;
			ans += now*2;
		}
		
		System.out.println(ans-max);
	}

}
