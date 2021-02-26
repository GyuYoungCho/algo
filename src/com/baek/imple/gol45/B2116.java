package com.baek.imple.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2116 {
	static int N;
	static int[][] arr;
	static int[] opp = { 0, 1, 2, 3, 5, 4, 6 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][7];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for( int j=1;j<=6;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i=1;i<=6;i++) {
			int front = opp[i];
			int back = opp[7-i];
			int sum = 0;
			for(int j=0; j<N; j++) {
				int value = 0;
				for(int k=1;k<=6;k++) {
					if(k==front||k==back) continue;
					value = Math.max(value, arr[j][k]);
					if(value==6) break;
				}
				sum+=value;
				if(j!=N-1) {
					for(int k=1;k<=6;k++) {
						
						if(arr[j+1][k]==arr[j][back]) {
							front = k;
							for(int l=1;l<=6;l++) {
								if(front == opp[l]) {
									System.out.println();
									back = opp[7-l];
									break;
								}
							break;
							}
						}
					}
				}
				System.out.println(back);
			}
			max = Math.max(sum, max);
			break;
			
		}
		System.out.println(max);
	}

}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
// 
//public class B2116 {
// 
//    static int N, dice[][], res;
//    static int[] opp = { 0, 6, 4, 5, 2, 3, 1 };
//    static boolean[][] isAdhere;
// 
//    public static void main(String[] args) throws IOException {
// 
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
// 
//        N = Integer.parseInt(br.readLine());
//        dice = new int[N][7];
//        
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            
//            for (int j = 1; j <= 6; j++) {
//                dice[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
// 
//        pileDice();
//        
//        System.out.println(res);
//    }
// 
//    private static void pileDice() {
// 
//        int up = 0;
//        for (int num = 1; num <= 6; num++) {
// 
//            isAdhere = new boolean[N][7];
//            for (int f = 1; f <= 6; f++) {
//                if(dice[0][f] == num) {
//                    up = dice[0][f];
//                    
//                    isAdhere[0][f] = isAdhere[0][opp[f]] = true;
//                    break;
//                }
//            }
//            for (int i = 1; i < N; i++) {
//                
//                for (int f = 1; f <= 6; f++) {
//                    if(dice[i][f] == up) {
//                        up = dice[i][opp[f]];
//                        isAdhere[i][f] = isAdhere[i][opp[f]] = true;
//                        break;
//                    }
//                }
//            }
//            res = Math.max(res, sumSide());
//        }        
//    }
// 
//    private static int sumSide() {  
//        int sum = 0;
//        for (int i = 0; i < N; i++) {
//            
//            int max = 0;
//            for (int j = 1; j <= 6; j++) {
//                if(!isAdhere[i][j])
//                    max = Math.max(max, dice[i][j]);
//            }
//            sum += max;            
//        }
//        return sum;
//    }
// 
//}