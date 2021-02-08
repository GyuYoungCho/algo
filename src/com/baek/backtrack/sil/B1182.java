package com.baek.backtrack.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182 {
	static int [] input;
	static int N, sum, Answer, count;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());
		
			
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		isSelected = new boolean[N];
		for(int i=0;i<N;i++) {
			input[i] =  Integer.parseInt(st.nextToken());
		}
		
		Answer = 0;
		count = 0;
		if(sum==0)
			Answer--;
		generateSubset(0);
		
		System.out.println(Answer);
	}
	
	static void generateSubset(int cnt) {
		if(count == 1 << (input.length-1))
			return;
		
		if(cnt==N) {
			int total = 0, total1 = 0;
			for(int i=0;i<N;i++) {
				if (isSelected[i])
					total+=input[i];
				else
					total1+=input[i];
			}
			if (total==sum)
				Answer++;
			if (total1==sum)
				Answer++;
			count++;
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}

}
