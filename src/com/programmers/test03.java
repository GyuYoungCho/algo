package com.programmers;

import java.util.*;

public class test03 {

	public static void main(String[] args) {
		int n=8;
		int k=2;
		String[] cmd = {"D 2","C","U 3","C","C","Z","Z","C"};
		System.out.println(solution(n,k,cmd));
	}
	public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        StringTokenizer st;
        Stack<int[]> stack = new Stack<>();
//        LinkedList<Integer> arr = new LinkedList<>();
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = i;
        }
        
        char cm='a';
        int num=0;
        for(int i=0;i<cmd.length;i++){
            if(cmd[i].length()>1){
                st = new StringTokenizer(cmd[i]);
                cm = st.nextToken().charAt(0);
                num = Integer.parseInt(st.nextToken());
            }else cm = cmd[i].charAt(0);
            
            if(cm=='U'){
                k-=num;
            }else if(cm=='D'){
                k+=num;
            }else if(cm=='C'){
                stack.add(new int[]{arr[k],k});
                arr[k]=-1;
                if(k!=arr.length) k++;
            }else if(cm=='Z'){
                int[] a = stack.pop();
                // if(a[0]>arr.size()) arr.offer(a[0]);
                // else{
                arr[a[1]] = a[0];
                
//                if(a[1]<=k) k++;
                // }
            }
            
            System.out.println(Arrays.toString(arr));
            
            
        }
//        int a = arr.get(0);
        StringBuilder sb = new StringBuilder();
//        boolean[] visit = new boolean[n];
//        for(int j=0;j<arr.size();j++){
//            visit[arr.get(j)] = true;
//        }
        for(int j=0;j<n;j++){
            if(arr[j]!=-1) sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }
}
