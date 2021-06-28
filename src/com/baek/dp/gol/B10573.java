package com.baek.dp.gol;

import java.io.*;

public class B10573 {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int N;
	static long[][] arr = new long[81][10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 10; i++) 
			arr[0][i] = 1;
		
		for (int i = 1; i < 81; i++){
			for (int j = 0; j <10; j++){
				for (int k = j; k < 10 ; k++) 
					arr[i][j] += arr[i-1][k];
			}
		}

		while (N-->0){
			boolean flag = false;
			String s = br.readLine();
			for (int i = 1; i < s.length(); i++){
				if (s.charAt(i) < s.charAt(i-1)){
					flag = true;
					break;
				}
			}
			if (flag) sb.append(-1).append("\n");
			else {
				long ans = arr[s.length()][0];
				
				for (int i = 0; i < s.length(); i++){
					char k = s.charAt(i);
					if (k-'0' != 9)
						ans -= arr[s.length()-i][k-'0'+1];
				}
				sb.append(ans-1).append("\n");
			}
		}
		System.out.println(sb);
	}

}
