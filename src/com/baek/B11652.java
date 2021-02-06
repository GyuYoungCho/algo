package com.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B11652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		int max = 1;
		long k=0, maxidx=0;
		for(int i=0;i<N;i++) {
			k = Long.parseLong(br.readLine());
			if(map.containsKey(k)){
                map.put(k,map.get(k)+1);
                if(max == map.get(k)){
                    maxidx = Math.min(maxidx, k);
                }else if(max < map.get(k)){
                    max=map.get(k);
                    maxidx = k;
                }
            }else {
                map.put(k,1);
                if(map.size()==1){
                    maxidx = k;
                }
                if(max  ==1){
                    maxidx = Math.min(maxidx, k);
                }
            }
		}
		
		System.out.println(maxidx);
		
	}
}
