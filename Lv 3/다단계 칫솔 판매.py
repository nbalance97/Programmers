def solution(enroll, referral, seller, amount):
    answer = [0] * len(enroll)
    people_idx = {key:i for i,key in enumerate(enroll)}
    for idx, sell in enumerate(seller):
        temp = 100 * amount[idx]
        who = people_idx[sell]
        while True:
            answer[who] += temp - temp // 10
            if temp // 10 == 0 or referral[who] == '-':
                break
            temp = temp // 10
            who = people_idx[referral[who]]
        
    return answer
