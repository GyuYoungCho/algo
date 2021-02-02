package com.baek.bisearch.sil3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1072 {
	static long X,Y,Z;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = Y * 100 / X;
		if(Z>=99)
            System.out.println(-1);
        else {
            binarySearch(1, X);
        }
    }
	private static void binarySearch(long start, long end) {
        long mid = 0, ratio = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            ratio = (Y + mid) * 100 / (X + mid);

            if (ratio > Z) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}
