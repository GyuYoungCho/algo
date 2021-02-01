package com.baek;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B9020 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[10001];
		check[0] = check[1] = true;

		for (int i = 2; i <= Math.sqrt(check.length); i++) {
			if (check[i] == true)
				continue;
			for (int j = i * i; j < check.length; j = j + i)
				check[j] = true;
		}

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			int first_partition = n / 2;
			int second_partition = n / 2;

			while (true) {

				if (!check[first_partition] && !check[second_partition]) {
					sb.append(first_partition).append(' ').append(second_partition).append('\n');
					break;
				}
				first_partition--;
				second_partition++;
			}
		}
		System.out.print(sb);
	}

}
