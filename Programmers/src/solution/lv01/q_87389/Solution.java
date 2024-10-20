package solution.lv01.q_87389;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // n = x*i + 1;
        answer = n - 1;
        
        for(int i = 1; i <= 1000; i++) {
        	if(answer == i*i) {
        		answer = i;
        	}
        }
        return answer;
    }
}
