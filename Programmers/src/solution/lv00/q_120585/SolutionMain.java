package solution.lv00.q_120585;

/*
  
	https://school.programmers.co.kr/learn/courses/30/lessons/120585
	
	문제 설명
	머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금해졌습니다. 
	머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때, 
	머쓱이보다 키 큰 사람 수를 return 하도록 solution 함수를 완성해보세요.
	
	array				height	result
	[149, 180, 192, 170]	167		3
	[180, 120, 140]			190		0

*/

public class SolutionMain {
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int[] arr = {149, 180, 192, 170};
		int height = 167;
		
		s.solution(arr, height);
	}
}
