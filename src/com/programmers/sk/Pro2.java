package com.programmers.sk;

public class Pro2 {

	public static void main(String[] args) {
		
		int n = 6;
		boolean clockwise = false;
		
		int[][] answer = new int[n][n];
        
        int cnt = 1, d = 0;
        int[] row,col;
        int[] dx = {1,0,-1,0},dy = {0,1,0,-1};

        if(clockwise) {
            d = 1;
            row = new int[]{0,-1,n-1,n}; 
            col = new int[]{-1,n-1,n,0};
        }else{
            row = new int[]{-1,0,n,n-1};
            col = new int[]{0,n,n-1,-1};
        }
        
        for(int i=n-1; i > 0; i-=2){
            for(int j=0; j<i; j++){
                for(int k=0;k<4;k++){
                    row[k] += dx[(d-k+4)%4];
                    col[k] += dy[(d-k+4)%4];
                   
                    answer[row[k]][col[k]] = cnt;
                }
                cnt++;
            }
            if(clockwise) d = (d+3)%4;
            else d = (d+1)%4;
        }
        
        for(int i=0; i< n; i++){
        	for(int j=0; j< n; j++){
            	System.out.print(answer[i][j]);
            }
        	System.out.println();
        }
	}

}
