package com.baek.string.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5525 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		String str = br.readLine();
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < M - 2; i++) {
			if (str.charAt(i) == 'I' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
				cnt++;
				if (cnt == N) {
					cnt--;
					result++;
				}
				i++;
			} else
				cnt = 0;
		}
		System.out.println(result);
	}
}
