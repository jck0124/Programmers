package solution.lv01.q_12977;

class Solution {
    public int solution(int[] nums) {
        int answer = -1;

        int count = 0;
        
        for(int i = 0; i < nums.length - 2; i++) { // 첫번째 숫자 선택
        	
        	for(int j = i + 1; j < nums.length - 1; j++) { // 두번째 숫자 선택
        		
        		for(int k = j + 1; k < nums.length ; k++) { // 세번째 숫자 선택
        			
        			int sum = nums[i] + nums[j] + nums[k]; // 숫자 3개의 합
        			boolean checkPrime = true; // 소수 확인
        			
        			for(int p = 2; p <= Math.sqrt(sum); p++) {
        				if(sum%p == 0) {
        					checkPrime = false;
        					break;
        				}
        			}
        			
        			if(checkPrime) { // 소수일 경우
        				count++;
        			}
        			
        		} // for - k
        		
        	} // for - j
        	
        } // for - i
        
        answer = count;

        return answer;
    }
}
