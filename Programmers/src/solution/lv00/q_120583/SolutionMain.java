package solution.lv00.q_120583;

/*
  
	https://school.programmers.co.kr/learn/courses/30/lessons/120583
	
	정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때, 
	array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요.
	
	array				n	result
	[1, 1, 2, 3, 4, 5]	1	2
	[0, 2, 3, 4]	1	0
	
*/


public class SolutionMain {
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int[] arr = {1, 1, 2, 3, 5, 5};
		int n = 0;
		s.solution(arr, n);
		
	}

}
