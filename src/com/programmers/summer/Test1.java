package com.programmers.summer;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		int p=19;
		int r=6;
		int map[][] = {{1, 28, 41, 22, 25, 79, 4},{39, 20, 10, 17, 19, 18, 8},
				{21, 4, 13, 12, 9, 29, 19},{58, 1, 20, 5, 8, 16, 9},{5, 6, 15, 2, 39, 8, 29},
				{39, 7, 17, 5, 4, 49, 5},{74, 46, 8, 11, 25, 2, 11}};
		System.out.println(solution(map,p,r));
	}
	public static int solution(int[][] maps, int p, int r) {
		int r2 = r/2;
		int max=0;
		for(int i=0;i<=maps.length;i++) {
			for(int j=0;j<=maps.length;j++) {
				int sum=0;
				for(int k=0;k<r;k++) {
					if(k<r2) {
						for(int l=0;l<2*(k+1);l++) {
							int nx = i+ (k-r2);
							int ny = j+ (-k+l-1);
							if(inside(nx,ny)) continue;
							if(l==0||l==2*(k+1)-1) {
								if(maps[nx][ny]<=p/2) sum++;
							}
							else if(maps[nx][ny]<=p) sum++;
						}
					}else {
						for(int l=0;l<2*(r-k);l++) {
							int nx = i+ (k-r2);
							int ny = j+ (k-r+l);
							if(inside(nx,ny)) continue;
							if(l==0||l==2*(r-k)-1) {
								if(maps[nx][ny]<=p/2) sum++;
							}
							else if(maps[nx][ny]<=p) sum++;
						}
						
					}
				}
				max = Math.max(sum, max);
			}
		}
		
		return max;
	}
	public static boolean inside(int x, int y) {
		return x<0||y<0||x>6||y>6;
	}
}
