package solution.lv00.q_120813;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        int length = 0;
        
        if(n%2 == 0) { // n이 짝수일 때
        	length = n/2;
        } else { // n이 홀수일 때
        	length = (n/2) + 1;
        }
        
        answer = new int[length];
        
        int count = 0; // answer의 index
        
        for(int i = 1; i <= n; i++) {
        	if( i%2 == 1 ) {
        		answer[count] = i;
        		count++;
        	}
        }
        
        return answer;
    }
}
