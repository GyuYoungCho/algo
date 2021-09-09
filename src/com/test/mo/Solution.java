package kakao.ans;

import java.util.*;
import java.io.*;

public class Solution {
	static int[][][] arr;
    static char[][] map;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int cnt, sum, r, c, se;
	public static void main(String[] args) {
		String[] grid = {"SSSSLRSLRLLSSSLRL","SSSSLRSLRLLSSSLRL","SSSSLRSLRLLSSSLRL","SSSSLRSLRLLSSSLRL","SSSSLRSLRLLSSSLRL","SSSSLRSLRLLSSSLRL","SSSSLRSLRLLSSSLRL"};
		
		r = grid.length;
        c = grid[0].length();
        arr = new int[r][c][4];
        map = new char[r][c];
        for(int i=0;i<r;i++){
            map[i] = grid[i].toCharArray();
        }
        
        sum = r*c*4;
        
        e:for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int d=0;d<4;d++){
                    if(arr[i][j][d]!=0) continue;
                    dfs(i,j,d,1);
                    
                    if(cnt==sum) {
                    	System.out.println(cnt);
                    	break e;
                    }
                }
            }
        }
        for(int a : answer) {
//        	System.out.println(a);
        }
	}
	public static void dfs(int a, int b, int d, int se){
        if(arr[a][b][d]!=0) {
            answer.add(se-1);
            return;
        }
        if(cnt==sum) {
        	
            answer.add(se);
            return;
        }
        arr[a][b][d] = se;
        cnt++;
        
        if(map[a][b] == 'S'){
            if(d==0) dfs(a,(b+1)%c, d,++se);
            else if(d==1) dfs((a+1)%r,b, d,++se);
            else if(d==2) dfs(a,(b-1+c)%c, d,++se);
            else if(d==3) dfs((a-1+r)%r,b, d,++se);
        }else if(map[a][b] == 'L'){
            d = (d+3)%4;
            if(d==0) dfs(a,(b+1)%c, d,++se);
            else if(d==1) dfs((a+1)%r,b, d,++se);
            else if(d==2) dfs(a,(b-1+c)%c, d,++se);
            else if(d==3) dfs((a-1+r)%r,b, d,++se);
        }else if(map[a][b] == 'R'){
            d = (d+1)%4;
            if(d==0) dfs(a,(b+1)%c, d,++se);
            else if(d==1) dfs((a+1)%r,b, d,++se);
            else if(d==2) dfs(a,(b-1+c)%c, d,++se);
            else if(d==3) dfs((a-1+r)%r,b, d,++se);
        }
    }
}
