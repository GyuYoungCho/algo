package com.baek.imple.sil12;

import java.io.*;
import java.util.StringTokenizer;

public class B2564 {
	static int R,C,N,d,k,dis, arr[], sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());	
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		for(int i=0;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			if(d==1) arr[i] = k;
			else if(d==2) arr[i] = 2*R + C - k;
			else if(d==3) arr[i] = 2*(R+C) - k;
			else arr[i] = R +k;
		}
		for(int i=0;i<N;i++) {
			dis = Math.abs(arr[i] - arr[N]);
			sum+=(dis<R+C)?dis: 2*(R+C)-dis;
		}
		System.out.println(sum);
	}

}
