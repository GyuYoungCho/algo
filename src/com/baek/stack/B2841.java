package com.baek.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2841 {
	static int N,P,num,line, count = 0;
	static Stack<Integer>[] arr = new Stack[6];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		for(int i=0;i<6;i++) {
			arr[i] = new Stack<>();
		}
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			line = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			while(true) {
				if(arr[line].isEmpty()) {
					arr[line].push(num);
					count++;
					break;
				}
				int peek = arr[line].peek();
				if(peek > num) {
					arr[line].pop();
					count++;
				}
				else if(peek<num){
					arr[line].push(num);
					count++;
					break;
				}else
					break;
			}
		}
		System.out.println(count);
	}
}
