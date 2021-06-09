package com.baek.string.gol;

import java.io.*;

public class B10096 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		if(N%2==0) {
			System.out.println("NOT POSSIBLE");
			return;
		}
		String str = br.readLine();
		int mid = N/2;
		String left = str.substring(0, mid);
        String right = str.substring(mid, N);
        boolean flag1 = isPossible(left, right);

        String left2 = str.substring(mid + 1, N);
        String right2 = str.substring(0, mid + 1);
        boolean flag2 = isPossible(left2, right2);

        if (flag1 && flag2) {
            if (!left.equals(left2)) System.out.println("NOT UNIQUE");
            else System.out.println(left);
        } else if (flag1) {
            System.out.println(left);
        } else if (flag2) {
            System.out.println(left2);
        } else {
            System.out.println("NOT POSSIBLE");
        }
		
		
	}
	static boolean isPossible(String left, String right) {
        int diff = 0;
        int j = 0;
        for (int i = 0; i < left.length(); i++) {
            if (diff > 1) return false;
            if (left.charAt(i) != right.charAt(j)) {
                i--;
                j++;
                diff++;
            } else j++;
        }
        return true;
    }
}
