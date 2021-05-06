def solution(s):
    answer = []
    s = s[1:len(s)-1] # 괄호 양쪽끝 제거
    
    nums = dict()
    
    while True:
        p1 = s.find("{")
        p2 = s.find("}")
        if p1 == -1:
            break
            
        temp = s[p1+1:p2] # 괄호 잘린 문자(4, 2, 3)
        cSet = ()
        
        while True:
            pos = temp.find(",") # , 기준으로 숫자들 slice
            
            if pos == -1:
                target = int(temp)
            else:
                target = int(temp[:pos])
            
            try: # 요소의 개수 저장
                nums[target] = nums[target] + 1
            except:
                nums[target] = 1
            
            if pos == -1:
                break
                
            temp = temp[pos+1:]
        
        s = s[p2+1:] # s 갱신(} 이후로)
    
    ditems = list(nums.items())
    ditems.sort(key = lambda x:x[1], reverse=True) # value 기준으로 sort
    for k, v in ditems:
        answer.append(k)
    
    return answer
