package solution.lv00.q_120844;

/*
  
	https://school.programmers.co.kr/learn/courses/30/lessons/120844
		
	정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다. 
	배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.
	
	numbers		direction	answer
	[1, 2, 3]	"right"		[3, 1, 2]
	[4, 455, 6, 4, -1, 45, 6]	"left"	[455, 6, 4, -1, 45, 6, 4]
	
*/


class SolutionMain {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		int[] arr = {1, 2, 3, 4, 5};
 		s.solution(arr, "left");
		
	}
}