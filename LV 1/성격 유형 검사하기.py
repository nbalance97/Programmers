from collections import defaultdict

def solution(survey, choices):
    answer = ''
    scores = defaultdict(lambda: 0)
    for idx, each_survey in enumerate(survey):
        if choices[idx] == 4:
            continue
        if choices[idx] == 1:
            scores[each_survey[0]] += 3
        if choices[idx] == 2:
            scores[each_survey[0]] += 2
        if choices[idx] == 3:
            scores[each_survey[0]] += 1
        if choices[idx] == 5:
            scores[each_survey[1]] += 1
        if choices[idx] == 6:
            scores[each_survey[1]] += 2
        if choices[idx] == 7:
            scores[each_survey[1]] += 3
    
    if scores['R'] >= scores['T']:
        answer += 'R'
    else:
        answer += 'T'
    
    if scores['C'] >= scores['F']:
        answer += 'C'
    else:
        answer += 'F'
        
    if scores['J'] >= scores['M']:
        answer += 'J'
    else:
        answer += 'M'
        
    if scores['A'] >= scores['N']:
        answer += 'A'
    else:
        answer += 'N'
        
    return answer
