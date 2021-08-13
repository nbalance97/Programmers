from itertools import combinations

# 유일성 만족 확인
def simulation(relation, columns):
    compare_set = set()
    for tup in relation:
        target = []
        for col in columns:
            target.append(tup[col])
        target = tuple(target)
        if target in compare_set:
            return False
        compare_set.add(target)
    return True

# 최소성 확인(자신보다 짧은 최소키가 있는지)
def check_in_set(candidate, case):
    case_len = len(case)
    
    for i in range(1, case_len+1):
        total_case = list(combinations(case, i))
        for case_ in total_case:
            if case_ in candidate:
                return False
    return True
    
            

def solution(relation):
    answer = 0
    col_len = len(relation[0])
    cols = [i for i in range(col_len)]
    candidate = set()
    for i in range(1, col_len+1):
        all_case = list(combinations(cols, i))
        for case in all_case:
            # 유일성과 최소성을 만족하는지 확인
            if check_in_set(candidate, case) and simulation(relation, case): 
                candidate.add(case)
                answer += 1

    return answer
