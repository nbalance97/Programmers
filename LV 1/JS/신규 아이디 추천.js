function solution(new_id) {
    var answer = new_id;
    // 1단계
    answer = new_id.toLowerCase()
    
    // 2단계
    let temp = ''
    for (let ch of answer) {
        if (('a' <= ch && ch <= 'z') ||
            ('0' <= ch && ch <= '9') ||
            ch === '-' || ch === '_' || ch === '.')  {
            temp = temp + ch
        }
    }
    answer = temp
    
    // 3단계
    let stack = []
    for (let ch of answer) {
        let l = stack.length;
        if (l !== 0) {
            if (ch === '.' && stack[l-1] === '.') {
                continue
            }
        } 
        stack.push(ch)
    }
    answer = stack.join('');
    
    // 4단계
    if (answer.length > 0 && answer[0] === '.')
        answer = answer.slice(1);
    if (answer.length > 0 && answer[answer.length-1] === '.')
        answer = answer.slice(0, -1);
    
    // 5단계
    if (answer.length === 0) {
        answer = 'a';
    }
    
    // 6단계
    if (answer.length >= 16) {
        answer = answer.slice(0, 15);
        if (answer[answer.length-1] === '.') 
            answer = answer.slice(0, -1);
    }
    
    if (answer.length <= 2) {
        answer = answer + answer[answer.length-1].repeat(3 - answer.length);
    }
    
    return answer;
}
