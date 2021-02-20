package com.baek.bisearch.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2110 {
	static int N,M;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		
		System.out.println(bs());
	}
	
	private static int bs() {
		int start = 1, end = arr.get(N-1) - arr.get(0);
		int mid, cnt;
		while (start <= end) {
			mid = (start + end) / 2;

			int prior = arr.get(0);
            cnt = 1;
            for (int i = 0; i < N; i++) {
                int dist = arr.get(i)- prior;
                if (dist >= mid) {
                    cnt++;
                    prior = arr.get(i);
                }
            }
			if (cnt >= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			
		}
		return start-1;
	}
}
