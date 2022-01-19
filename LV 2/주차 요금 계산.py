from collections import defaultdict
import math

def htom(s):
    return 60 * int(s[:2]) + int(s[3:])


def solution(fees, records):
    answer = []
    park_time = defaultdict(lambda: 0)
    in_time = defaultdict(lambda: 0)
    for record in records:
        time, number, status = record.split()
        if status == 'IN':
            in_time[number] = htom(time) 
        if status == 'OUT':
            park_time[number] += htom(time) - in_time[number]
            in_time[number] = -1
    
    last_time = htom("23:59")
    default_time, default_fee, per_minute, per_fee = fees
    for key in sorted(in_time.keys()):
        if in_time[key] != -1:
            park_time[key] += last_time - in_time[key]
        if park_time[key] <= default_time:
            answer.append(default_fee)
        else:
            answer.append(default_fee + (
                math.ceil((park_time[key] - default_time) / per_minute)
            ) * per_fee)
    
    
    
    return answer
