package com.baek.bit.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12025 {
	static long K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr = br.readLine().toCharArray();
		int[] num = new int[arr.length];
		
		int cnt = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == '1' || arr[i] == '2' || arr[i] == '6' || arr[i] == '7') {
				num[cnt++] = i;
				if (arr[i] == '6')
					arr[i] = '1';
				else if (arr[i] == '7')
					arr[i] = '2';
			}
		}
		
		K = Long.parseLong(br.readLine());
		K--;
		long maximum = (long) Math.pow(2, cnt);

		if (maximum < K) {
			System.out.println(-1);
			return;
		}
		cnt = 0;
		while (K > 0) {
			if(K%2==1) {
				if (arr[num[cnt]] == '1') arr[num[cnt]] = '6';
				else if (arr[num[cnt]] == '2') arr[num[cnt]] = '7';
			}
			K/=2;
			cnt++;
		}
		
		for(char c : arr)
			sb.append(c);
		
		System.out.println(sb);
	}

}
