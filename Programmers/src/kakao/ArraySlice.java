package kakao;

import java.util.Arrays;

/*
	정수배열 arr과 query
	
	query를 순회하면서 다음 작업을 반복한다
	짝수 인덱스에서는 arr에서 query[i]번 인덱스의 뒷부분을 잘라서 버린다
	홀수 인덱스에서는 arr에서 query[i]번 인덱스의 앞부분을 잘라서 버린다
	
	위 작업을 마친 후 남은 arr의 부분 배열을 return하는 solution 클래스 완성
	
	(입출력 예)
			arr				query		 result	
	[0, 1, 2, 3, 4, 5]	  [4, 1, 2]		[1, 2, 3]
	
	query의 값 		query 처리 전 			  query 처리 후
		4		  [0, 1, 2, 3, 4, 5]	[0, 1, 2, 3, 4]
		1		  [0, 1, 2, 3, 4]		[1, 2, 3, 4]	
		2		  [1, 2, 3, 4]			[1, 2, 3]
		
		arr.length = 6; query[i] = 3 -> arr.length = 3
		[0, 1, 2, 3, 4, 5] -> [x, x, x, 3, 4, 5]
		temp[0] = arr[j + 3] = arr[j + query[i]]
		
		arr.length = 6; query[i] = 1 -> arr.length = 5
		[0, 1, 2, 3, 4, 5] -> [x, 1, 2, 3, 4, 5]
		
		arr.length = 5; query[i] = 3 -> arr.length = 2
		[0, 1, 2, 3, 4] -> [x, x, x, 3, 4]
		temp[0] = arr[j + 3] = arr[j + query[i]]
		
		arr.length = 5; query[i] = 1 -> arr.length = 4
		[0, 1, 2, 3, 4] -> [x, 1, 2, 3, 4]
		temp[0] = arr[j + 1] = arr[j + query[i]]
		
		순회 후 arr.length = arr.length - query[i]
*/

class Solution2{
	public int[] solution(int[] arr, int[] query) {
		
		int[] answer = {};
		
		// System.out.println("초기 arr  : " + Arrays.toString(arr));
		// System.out.println("query  : " + Arrays.toString(query));
		
		for(int i = 0; i < query.length; i++) {
			if(query[i]%2 == 0) { // query가 짝수일 때
				int[] temp = new int[query[i] + 1];
				for(int j = 0; j < temp.length; j++) {
					temp[j] = arr[j];
				}
				arr = temp;
			} else { // query가 홀수일 때
				int[] temp = new int[arr.length - query[i]];
				for(int j = 0; j < temp.length; j++) {
					temp[j] = arr[j + query[i]];
				}
				arr= temp;
			}
			// System.out.println(i + "번째 arr : " + Arrays.toString(arr));
		}
		
		
		
		// System.out.println(Arrays.toString(arr));
		// System.out.println(Arrays.toString(answer));
		
		answer = arr;
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}


public class ArraySlice {
	public static void main(String[] args) {

		// int[] arr =  {0, 1, 2, 3, 4, 5};
		// int[] query = {4, 1, 2};
		
		int[] arr =  {1, 2, 3, 4, 5, 6, 7, 8};
		int[] query = {5, 2};
		
		Solution2 s2 = new Solution2();
		s2.solution(arr, query);
	}
}
