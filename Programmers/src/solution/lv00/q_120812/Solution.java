package solution.lv00.q_120812;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        // array의 요소를 arrayCount의 index로 
        int[] arrayCount = new int[1000];
        
        // array의 각 요소의 개수만큼 arrayCount++ 
        for(int i = 0; i < array.length; i++) {
        	arrayCount[ array[i] ]++;
        }
        
        
        // array에서 최빈값 개수
        int answerCount = 0;
        
        // 최빈값이 여러개
        int modeCount = 0;
        
        for(int i = 0; i < arrayCount.length; i++) {
        	if( arrayCount[i] > answerCount ) { // 최빈값 구하기
        		answer = i;
        		answerCount = arrayCount[i];
        		modeCount = 0;
        	} else if( arrayCount[i] == answerCount ) { // 최빈값이 여러개
        		modeCount++;
        	}
        }
        
         
        if(modeCount > 0) {
        	answer = -1;
        }
        
        
        return answer;
    }
}