package com.baek.dp.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12783 {
	static int T, N,M,K, min;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				
				K = Integer.parseInt(br.readLine());
				min = 25;
				minCard(K,0);
				
				sb.append(min==25?-1:min).append("\n");
			}
			
		}
		System.out.println(sb.toString());
	}
	private static void minCard(int result, int cnt) {
		if (result < arr[0])
			return;

		int temp = result;
		while (true)
		{
			if (temp == 0)
			{
				min = cnt < min ? cnt : min;
				return;
			}
			boolean flag = false;
			for (int i = 0; i < N; i++)
				if (temp % 10 == arr[i])
				{
					flag = true;
					break;
				}
			if (!flag)
				break;
			temp /= 10;
		}

		for (int i = 0; i < N; i++)
			if (arr[i] > 1 && result % arr[i] == 0)
				minCard(result / arr[i], cnt + 1);
	}
}
