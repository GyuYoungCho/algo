package com.baek.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2304 {
	static int N, last, max, height[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

        height = new int[1001];
        height[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int h= Integer.parseInt(st.nextToken());
            
            height[num] = h;
            if (last < num) last = num;
            if (height[max] < h) max = num;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int area = height[max];
        for (int i = 0; i < max; i++) {
            if (stack.peek() < height[i])
            	stack.push(height[i]);
            area += stack.peek();
        }

        stack.clear();
        stack.push(0);
        
        for (int i = last; i > max; i--) {
            if (stack.peek() < height[i]) 
            	stack.push(height[i]);
            area += stack.peek();
        }

        System.out.println(area);
	}

}
