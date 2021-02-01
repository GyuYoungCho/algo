package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr1 = new int[N];
		int [] counting = new int[8001];
		
		int sum = 0;
		int max = -4000;
		int min = 4000;
	    
	    for(int i=0;i<N;i++) {
	    	arr1[i] = Integer.parseInt(br.readLine());
			sum+=arr1[i];
			counting[arr1[i]+4000]++;
			max = Math.max(arr1[i], max);
			min = Math.min(arr1[i], min);
		}
	    
	    Arrays.sort(arr1);
	    int count_max = 0;
	    int max_index = 10000;
	    int second = 10000;
	    int index;
	    for(int i=N-1;i>=0;i--) {
	    	if (count_max < counting[arr1[i]+4000]){
	    		max_index = arr1[i];
	    		second = 10000;
	    		count_max = counting[arr1[i]+4000];
	    	}else if(count_max == counting[arr1[i]+4000]) {
	    		if(max_index == arr1[i])
	    			continue;
	    		second = max_index;
	    		max_index = arr1[i];
	    	}
	    }
	    index = (second!=10000)? second : max_index;
	    System.out.printf("%d\n%d\n%d\n%d",Math.round((double)sum/N),arr1[N/2], index ,max-min);
	}

}
