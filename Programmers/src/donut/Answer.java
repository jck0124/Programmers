package donut;

import java.util.Arrays;

/*
	1. 도넛모양 그래프
	n개의 정점, n개의 간선, n-1개의 정점 한 번씩 방문
	
	2. 막대모양 그래프
	n개의 정점, n-1개의 간선, n-1개의 정점을 한 번씩 방문
	
	3. 8자모양 그래프
	2n+1개의 정점, 2n+2개의 간선
	
	
	도넛 모양, 막대 모양, 8자 모양 그래프가 여러 개 있다.
	이 그래프들과 무관한 정점을 하나 생성한 뒤, 
	각 도넛, 막대, 8자 모양 그래프의 임의의 정점 하나로 향하는 간선들을 연결
	그 후 각 정점에서 서로 다른 번호를 매김
	
	그래프의 간선 정보가 주어지면 생성한 정점의 번호와 정점을 생성하기 전
	도넛, 막대, 8자 모양 그래프의 수를 구해야 한다.
	
	그래프의 간선 정보를 담은 2차원 정수 배열 edges가 파라미터로 주어진다
	edges의 원소는 [a,b] 형태이며, a번 정점에서 b번 정점으로 향하는 간선이 있다는 것을 나타낸다
	이때, 생성한 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수를
	순서대로 1차원 정수 배열에 담아 return하도록 solution 함수를 완성
	※도넛 모양 그래프, 막대 모양 그래프, 8자 모양 그래프의 수의 합은 2이상
	
	(실행결과의 예)
	[
		[2, 3], [4, 3], [1, 1], [2, 1]
	] 
	-> [2, 1, 1, 0]
	
	[
		[4, 11], [1, 12], [8, 3], [12, 7], [4, 2], 
		[7, 11], [4, 8], [9, 6], [10, 11], [6, 10], 
		[3, 5], [11, 1], [5, 3], [11, 9], [3, 8]
	]
	-> [4, 0, 1, 2]
	
*/

class Solution {
	
	public static boolean checkDonut(int[][] edges, int num) {
		for(int i = 0; i < edges.length; i++) {
			if(edges[i][1] == num) {
				return true;
			}
		}
		
		for(int i = 0; i < edges.length; i++) {
			if(edges[i][0] == num) {
				// 재귀호출
				return checkDonut(edges, edges[i][1]);
			}
		}
		return false;
	}
	// num = 3, 
	
	public int[] solution(int[][] edges) {
		int[] answer = {};
		/*
			1. 도넛모양 그래프
			n개의 정점, n개의 간선, n-1개의 정점 한 번씩 방문
			모든 정점은 출발 1번, 도착 1번 -> 모든 정점이 출발 1번, 도착 1번이면 도넛모양이 있다 + 도착점에서 출발점으로 가는 간선이 있음
			
			2. 막대모양 그래프
			n개의 정점, n-1개의 간선, n-1개의 정점을 한 번씩 방문
			- 첫번째 정점은 출발 1번, 도착 0번
			- 중간 정점은 출발 1번, 도착 1번
			- 마지막 정점은 출발 0번, 도착 1번 -> 출발 or 도착이 1번만 있는 정점이 있으면 막대 모양이 있다 + 도착점에서 출발점으로 가는 간선X
			
			3. 8자모양 그래프
			2n+1개의 정점, 2n+2개의 간선
			- 중앙 정점은 출발 2번, 도착 2 -> 출발 2번, 도착 2번인 그래프가 있다면 8자 모양이 있다
			나머지는 출발 1번, 도착 1번
			
			생성한 정점에서 모든 그래프의 정점 중 하나로 간선을 그음  -> 추가된 간선 개수 = 모든 그래프의 개수의 합
			모든 정점의 개수 : 모든 그래프의 정점 개수의 합 + 1
		*/
		
		
		/*
		 	생성한 정점 : 출발만 있고 도착은 없다(막대모양 출발점과 차이 생각) 
		 	막대모양 그래프 1개만 있을 경우? -> 문제조건 : 모든 그래프의 수의 합은 2이상 (불가능)
		 	생성한 정점 -> 출발이 2이상이고 도착이 0
		*/
		int[] arr1 = new int[edges.length + 1]; // 정점 n번에서의 출발 횟수, 배열의 크기 나중에 다시 설정?
		int[] arr2 = new int[edges.length + 1]; // 정점 n번으로의 도착 횟수 
 		for(int i = 0; i < edges.length; i++) {
 			arr1[edges[i][0]]++;
 			arr2[edges[i][1]]++;
		}
 		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		
 		int create = 0; // 정점 번호
 		for(int i = 0; i < edges.length + 1; i++) {
 				if(arr1[i] >= 2) {
 					if(arr2[i] == 0) {
 						create = i;
 					}
 			}
 		}
		System.out.println("생성한 정점의 번호 : " + create + ", 그래프의 개수 : " + arr1[create]);
		
		
		// 생성한 정점에서 각 그래프의 임의의 정점으로 가는 간선의 개수 빼주기
		for(int i = 0; i < edges.length; i++) {
				if(edges[i][0] == create) {
					arr1[edges[i][0]]--;
					arr2[edges[i][1]]--;
				}
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));

		/*
			막대모양의 개수 = 출발은 0이고 도착인 1인 점의 개수
			크기가 1인 막대 그래프도 create로 부터 생긴 간선이 있으므로 출발 0, 도착1 성립
		*/
		int stick = 0;
		
		
		System.out.println("막대모양 그래프의 개수 : " +  stick);
		
		/*
			도넛모양의 개수 
			출발 1이고 도착이 1이며, 도착지가 출발지로 돌아오는 그래프
			-> 막대모양 중간과 구분?
			
		*/
		System.out.println(checkDonut(edges, 2));
		
		/*
			8자 모양 : 전체 그래프 개수 - 막대 모양 - 도넛 모양
		*/
		
		
		return answer;
	}
}


public class Answer {
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int[][] edges1 = { // [2, 1, 1, 0]
				{2, 3}, {4, 3}, {1, 1}, {2, 1}
		};
		s.solution(edges1); // [2, 1, 1, 0]
		
//		int[][] edges2 = { // [4, 0, 1, 2]
//				{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, 
//				{7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, 
//				{3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8},
//		};
//		s.solution(edges2); // [4, 0, 1, 2]
		
		
		
		
	}
}
