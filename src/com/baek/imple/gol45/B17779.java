package com.baek.imple.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17779 {
	static int N, result = Integer.MAX_VALUE, min = 99999, max=0;
	static int arr[][], temp[][];
	static int d1, d2, x1, y1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		solve();
		System.out.println(result);
	}
	
	private static void solve() {
		for(int i=1; i<=N; i++){
            d1 = i;
            for(int j=1; j<=N; j++){
                d2 = j;
                for(int x =1; x<=N; x++){
                    if(x+d1+d2 >= N) continue;
                    x1 = x;
                    for(int y=1; y<=N; y++){
                        if( 1 > y-d1 || y+d2 > N) continue;
                        y1 = y;
                        temp = new int[N+1][N+1];
                        fiveBoundary();
                        divideMap();
                        result = Math.min(result,cal());
                    }
                }
            }
        }
	}
	
	static void fiveBoundary(){
        for(int i=0; i<=d1; i++){
            temp[x1+i][y1-i] = 5;
            temp[x1+d2+i][y1+d2-i]=5;
        }
        for(int i=0; i<=d2; i++){
            temp[x1+i][y1+i] = 5;
            temp[x1+d1+i][y1-d1+i] = 5;
        }

        for(int i = 0; i < d2; i++){
            int t = 1;
            while(temp[x1 + i + t][y1 + i] != 5){
                temp[x1 + i + t][y1 + i] = 5; t++;
            }
        }

        for(int i = 0; i < d1; i++){
            int t = 1;
            while(temp[x1 + i + t][y1 - i] != 5){
                temp[x1 + i + t][y1 - i] = 5; t++;
            }
        }

    }


    static void divideMap(){
        for(int r=1; r<x1+d1; r++){
            for(int c=1; c<=y1; c++){
                if(temp[r][c] == 5) continue;
                temp[r][c] = 1;
            }
        }

        for(int r=1; r<=x1+d2; r++){
            for(int c=y1+1; c<=N; c++){
                if(temp[r][c] == 5) continue;
                temp[r][c] = 2;
            }
        }

        for(int r=x1+d1; r<=N; r++){
            for(int c=1; c<y1-d1+d2; c++){
                if(temp[r][c] == 5) continue;
                temp[r][c] = 3;
            }
        }

        for(int r=x1+d2+1; r<=N; r++){
            for(int c=y1-d1+d2; c<=N; c++){
                if(temp[r][c] == 5) continue;
                temp[r][c] = 4;
            }
        }

    }

    static int cal(){
        int a=0, b=0, c=0, d=0, e=0;
        max = 0;
        min = 99999;
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(temp[i][j] == 1){
                    a += arr[i][j];
                } else if(temp[i][j] == 2){
                    b += arr[i][j];

                } else if(temp[i][j] == 3){
                    c += arr[i][j];

                } else if(temp[i][j] == 4){
                    d += arr[i][j];

                } else {
                    e += arr[i][j];
                }
            }
        }

        if( a > max) max = a;
        if( b > max) max = b;
        if( c > max) max = c;
        if( d > max) max = d;
        if( e > max) max = e;

        if( min > a ) min = a;
        if( min > b ) min = b;
        if( min > c)  min = c;
        if( min > d)  min = d;
        if (min > e)  min = e;

        return max-min;

    }
}
