package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1049 {

	static int N,M, pac, one ,need_pac, need_one;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Stack<Integer> p = new Stack<Integer>();
		Stack<Integer> o = new Stack<Integer>();
		need_pac = N/6; need_one = N%6;
		st = new StringTokenizer(br.readLine());
		p.push(Integer.parseInt(st.nextToken()));
		o.push(Integer.parseInt(st.nextToken()));
		for(int i=0;i<M-1;i++) {
			st = new StringTokenizer(br.readLine());
			pac = Integer.parseInt(st.nextToken());
			one = Integer.parseInt(st.nextToken());
			if(p.peek()>pac) {
				p.pop();
				p.push(pac);
			}
			if(o.peek()>one) {
				o.pop();
				o.push(one);
			}
		}
		
		int min = Math.min((need_pac+1)*p.peek(), N*o.peek());
		System.out.println(Math.min(min,need_pac*p.pop() + need_one*o.pop()));
	}

}
