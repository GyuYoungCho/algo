package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11650 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [][]arr1 = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			arr1[i][0] = Integer.parseInt(st.nextToken());
			arr1[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr1, (e1, e2) ->{
			if(e1[0]==e2[0])
				return e1[1] - e2[1];
			else
				return e1[0] - e2[0];
		});
		
		for(int i=0;i<N;i++)
			sb.append(arr1[i][0]).append(" ").append(arr1[i][1]).append("\n");
		
		System.out.println(sb);
	}

}
