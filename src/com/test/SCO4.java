package com.test;

import java.io.*;
import java.util.*;
class SCO4 {
	static String[][] abc = new String[5][2];
	static char[][] open, arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			abc[i][0] = Character.toString((char)(65+i));
			abc[i][1] = st.nextToken();
		}
		
		Arrays.sort(abc, (o1,o2)->{
			return o2[1].compareTo(o1[1]);
		});
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		open = new char[N][M];
		arr = new char[N][M];
		
		for(int i=0;i<N;i++){
			open[i] = br.readLine().toCharArray();
		}
		for(int i=0;i<N;i++){
			arr[i] = br.readLine().toCharArray();
		}
		
		ArrayList<char[]> y = new ArrayList<>();
		ArrayList<char[]> o = new ArrayList<>();
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if(open[j][i]=='Y') {
					y.add(new char[] {arr[j][i],(char)(j+'0'),(char)(i+'0')});
				}
				else if(open[j][i]=='O') {
					o.add(new char[] {arr[j][i],(char)(j+'0'),(char)(i+'0')});
				}
			}
		}
		
		
		for(int i=0;i<5;i++) {
			for(char[] y1 : y) {
				if(Character.toString(y1[0]).equals(abc[i][0])) {
					sb.append(y1[0]).append(" ").append(abc[i][1]).append(" ").append(y1[1]).append(" ").append(y1[2]).append("\n");
				}
			}
		}
		for(int i=0;i<5;i++) {
			for(char[] y1 : o) {
				if(Character.toString(y1[0]).equals(abc[i][0])) {
					sb.append(y1[0]).append(" ").append(abc[i][1]).append(" ").append(y1[1]).append(" ").append(y1[2]).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
