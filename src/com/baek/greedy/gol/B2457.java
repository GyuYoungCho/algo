package com.baek.greedy.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2457 {
	static int N, ans, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<int[]> arr = new ArrayList<>();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s_m = Integer.parseInt(st.nextToken());
			int s_d = Integer.parseInt(st.nextToken());
			int e_m = Integer.parseInt(st.nextToken());
			int e_d = Integer.parseInt(st.nextToken());
			arr.add(new int[] { s_m * 40 + s_d, e_m * 40 + e_d });
		}
		Collections.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
		});
		
		int id = 0;
		int start = 121;
		
		while (start < 481) {
			max = 0;
			boolean flag = false;
			for (int i = id; i < N; i++) {
				int[] cur = arr.get(i);
				if (cur[0] > start)
					break;
				if (cur[0] <= start && max < cur[1]) {
					max = cur[1];
					id = i + 1;
					flag = true;
				}
			}
			if (flag) {
				start = max;
				ans++;
			} else
				break;
		}
		System.out.println(max<481?0:ans);
	}

}
