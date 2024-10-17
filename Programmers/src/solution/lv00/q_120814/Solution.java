package solution.lv00.q_120814;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n%7 == 0) {
        	answer = n/7;
        } else {
        	answer = (n/7) + 1;
        }
        
        return answer;
    }
}
