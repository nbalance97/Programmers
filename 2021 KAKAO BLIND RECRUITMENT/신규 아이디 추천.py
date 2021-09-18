import re

def solution(new_id):
    answer = ''
    # 1단계
    new_id = new_id.lower()
    
    # 2단계
    temp = re.findall(r"[a-z|0-9|\-|_|.]", new_id)
    new_id = "".join(temp)
    
    # 3단계
    temp = " "
    for p in new_id:
        if p == ".":
            if temp[-1] != ".":
                temp = temp + "."
        else:
            temp = temp + p
    new_id = temp[1:]
    
    # 4단계   
    new_id = new_id.strip('.')
    
    # 5단계
    if len(new_id) == 0:
        new_id = "a"
    
    # 6단계
    if len(new_id) >= 16:
        new_id = new_id[:15]
        new_id = new_id.rstrip('.')
    
    # 7단계
    if len(new_id) <= 2:
        new_id = new_id + new_id[-1] * (3 - len(new_id))

    answer = new_id
    return answer

# ----------------------------------------------------------------

def solution(new_id):
    import re
    answer = ''
    new_id = new_id.lower()
    temp = re.findall(r"[a-z|0-9|\-|_|.]", new_id)
    new_id = "".join(temp)
    
    temp = " " # 처음엔 공백 넣어줫다 나중에 뺌
    for p in new_id:
        if p == ".":
            if temp[-1] == ".":
                continue
            else:
                temp = temp + "."
        else:
            temp = temp + p
    temp = temp[1:]
    new_id = temp
    
    if len(new_id) != 0 and new_id[0] == ".":
        new_id = new_id[1:]
    if len(new_id) != 0 and new_id[-1] == ".":
        new_id = new_id[:len(new_id)-1]

    if len(new_id) == 0:
        new_id = "a"
    
    if len(new_id) >= 16:
        new_id = new_id[:15]
        
    if len(new_id) != 0 and new_id[-1] == ".":
        new_id = new_id[:len(new_id)-1]
    
    if len(new_id) <= 2:
        new_id = new_id + new_id[-1] * (3 - len(new_id))

    answer = new_id
    return answer
