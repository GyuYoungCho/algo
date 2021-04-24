package com.baek.math.sil;

public class B1861 {

	public static void main(String[] args) {
		int a = 15;
		int ans = 0;
		for (int i = 0; i < 2; i++) {
			ans+=Math.pow(9, i)* a%10;
			a/=10;
		}
		System.out.println(ans);
	}

}
