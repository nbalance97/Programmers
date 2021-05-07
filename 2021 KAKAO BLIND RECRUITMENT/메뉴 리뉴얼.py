def solution(orders, course):
    from itertools import combinations
    answer = []
    
    ans = {c:0 for c in course}
    ans_dict = {}
    for o in orders:
        for c in course:
            if len(o) < c:
                break
            temp = combinations(o, c)
            for t in temp:
                st = "".join(sorted(t))
                try:
                    ans_dict[st] = ans_dict[st] + 1
                except:
                    ans_dict[st] = 1
                ans[len(st)] = max(ans[len(st)], ans_dict[st])
    
    for key,value in ans_dict.items():
        if value >= 2 and value == ans[len(key)]:
            answer.append(key)
    
    answer.sort()
    
    return answer
