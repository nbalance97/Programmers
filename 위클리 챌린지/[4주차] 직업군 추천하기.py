def solution(table, languages, preference):
    answer = ''
    
    score = {languages[i]: preference[i] for i in range(len(languages))}    
    max_score = 0
    for information in table:
        inf = information.split()
        # 언어별 점수 부여
        current_score = {inf[i]: 6-i for i in range(1, len(inf))}
        total_score = 0
        # 현재 직업에서의 점수 구함
        for lan in score.keys():
            if current_score.get(lan) != None:
                total_score += (current_score[lan] * score[lan])
        
        # 동점이면 사전순으로 앞서는걸 정답으로
        if total_score == max_score:
            if answer > inf[0]:
                answer = inf[0]
                
        # 최대 점수일때 갱신
        if total_score > max_score:
            max_score = total_score
            answer = inf[0]
            
    return answer
