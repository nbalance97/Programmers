def solution(s):
    answer = len(s)
    
    for step in range(1, len(s)//2+1):
        pos = 0
        make_string = ''
        while pos < len(s):
            count = 1
            temp = s[pos:pos+step]
            pos = pos + step
            for pos in range(pos, len(s), step):
                if temp == s[pos:pos+step]:
                    count += 1
                    pos = pos + step
                else:
                    break

            if count > 1:
                make_string += (str(count) + temp)
            else:
                make_string += temp

        answer = min(answer, len(make_string))
        
    return answer
            
                
            
        
