function solution(lottos, win_nums) {
    var answer = [];
    var zero_count = 0;
    var correct_count = 0;
    
    for (let lotto of lottos) {
        if (lotto == 0) {
            zero_count++;
        } else {
            if (win_nums.indexOf(lotto) != -1) {
                correct_count++;            
            }
        }
    }
    
    answer[0] = Math.min(6, 7 - (zero_count + correct_count));
    answer[1] = Math.min(6, 7 - correct_count);
    
    return answer;
}
