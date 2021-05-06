from itertools import product

def match(user_id, banned_id):
    if len(user_id) != len(banned_id):
        return False
    
    for i in range(len(user_id)):
        if banned_id[i] == "*":
            continue
        if banned_id[i] != user_id[i]:
            return False    
    return True
        

def solution(user_id, banned_id):
    answer = 0
    bucket = [[] for _ in range(len(banned_id))]
    
    for idx, banned in enumerate(banned_id):
        for idx2, user in enumerate(user_id):
            if match(user, banned):
                bucket[idx].append(idx2)
    
    tot_list = set()
    prod = list(product(*bucket))
    for pd in prod:
        if len(set(pd)) == len(pd):
            pd = sorted(pd)
            if tuple(pd) not in tot_list:
                tot_list.add(tuple(pd))
                answer = answer + 1
    return answer
