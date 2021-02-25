package com.baek.imple.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2564 {
	static int R,C,N, arr[], sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		for(int i=0;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			// 시계방향으로 거리계산
			if(d==1) arr[i] = k;
			else if(d==2) arr[i] = 2*R + C - k;
			else if(d==3) arr[i] = 2*(R+C) - k;
			else arr[i] = R +k;
		}
		
		for(int i=0;i<N;i++) {
			int temp = Math.abs(arr[i] - arr[N]);
			sum+=(temp<R+C)?temp: 2*(R+C)-temp;
		}
		System.out.println(sum);
	}

}
