package com.baek.math.gol;

import java.io.*;
import java.util.*;

public class B16400 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer>list = new ArrayList<>();
        boolean[] prime = new boolean[40001];
        
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) 
                    prime[j] = true;
            }
        }
        
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) {
                list.add(i);
            }
        }

        arr = new int[40001];
        arr[0] = 1;
        for (int i = 0; i < list.size(); i++) {
            int cnt = list.get(i);
            for (int j = cnt; j <= N; j++) {
                arr[j] = (arr[j] + arr[j - cnt]) % 123456789;
            }
        }
        System.out.println(arr[N]);
	}

}
