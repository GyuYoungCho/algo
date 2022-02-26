package com.baek.sort;

public class Mergesort {
	/* binary tree 형태로 쪼개기 때문에 가질 수 있는 최대 깊이는 log n이 된다
	 * 각 분할 (n개) 별로 합병을 진행하므로 시간 복잡도는 O(nlogn)
	 */
	public static int[] src;
	public static int[] tmp;
	public static void main(String[] args) {
		src = new int[]{1, 7, 8, 5, 4, 2, 3, 7, 6};
		tmp = new int[src.length];
		printArray(src);
		mergeSort(0, src.length-1);
		printArray(src); 
	} 
	
	
	public static void mergeSort(int start, int end) {
		if (start<end) {
			int mid = (start+end) / 2; //start와 end의 중간 지점을 저장
			mergeSort(start, mid); // 시작점부터 중간 점 분할
			mergeSort(mid+1, end); // 중간점 다음부터 끝점 분할
			int p = start; int q = mid + 1; // 각 분할의 첫번째 인덱스
			int idx = p; // 값 저장 인덱스
			
			while (p<=mid || q<=end) { //두 분할에서 다 가져올때 종료
				if (q>end || (p<=mid && src[p]<=src[q])) {
					// 두번째꺼 다 가져온 경우 or
					// 첫번째꺼 아직 있고 두 번째 분할 위치값보다 작은 경우
					// 같을 경우 상관없지만 인덱스 유지를 위해 여기에 조건 걸음
					tmp[idx++] = src[p++]; //해당 값을 넣고 다음 인덱스
				} else { // 나머지 경우(첫번째꺼 다 가져오거나 값 작은 경우 등)
					tmp[idx++] = src[q++]; 
					} 
				}
			
			for (int i=start;i<=end;i++) { // 모든 원소를 가져와 정렬된 값을 저장
				src[i]=tmp[i]; 
			} 
		} 
	} 
	
	public static void printArray(int[] a) {
		for (int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}