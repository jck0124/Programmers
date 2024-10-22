package solution.lv01.q_12954;

// 오답  - 오버플로우 
// 자바는 피연산자에 데이터타입에 따라 연산이 이루어짐
// 자바에서 배열의 인덱스는 반드시 int
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        
        answer = new long[n];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = x + ( (long)x * i);
        }
        
        return answer;
    }
}