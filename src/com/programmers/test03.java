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
	
//	public String[] solution(String[] s) {
//        String[] answer = new String[s.length];
//        
//        for(int i=0;i<s.length; i++){
//            StringBuilder sb = new StringBuilder(s[i]);
//            answer[i] = sb.toString();
//            if(sb.length()<4) {
//                continue;
//            };
//            if(sb.length()<6) {
//                for(int j=0;j<=sb.length()-3;j++){
//                    if(sb.substring(j,j+3).equals("110")){
//                        sb.delete(j,j+3);
//                        for(int k=0;k<=sb.length();k++){
//                            sb.insert(k,"110");
//                            if(answer[i].compareTo(sb.toString())>0)
//                                answer[i] = sb.toString();
//                            sb.delete(k,k+3);
//                        }
//                    }
//                }
//                
//                continue;
//            };
//            int start=0;
//            for(int j=0;j<=sb.length()-3;j++){
//                String sk = sb.substring(j,j+3);
//                if(sk.equals("110")){
//                    sb.delete(j,j+3);
//                    boolean flag = false;
//                    for(int k=start;k<=sb.length()-3;k++){
//                        if(sb.substring(k,k+3).equals("111")){
//                            sb.insert(k,"110");
//                            start= (k+3);
//                            j-=2;
//                            flag = true;
//                            break;
//                        }
//                    }
//                    if(!flag) {
//                        sb.insert(sb.length()-3,"110");
//                        
//                    }
//                    
//                    
//                }
//                
//                if(sk.charAt(2)=='0') j+=3;
//            }
//            answer[i] = sb.toString();
//        }
//        return answer;
//    }
}
