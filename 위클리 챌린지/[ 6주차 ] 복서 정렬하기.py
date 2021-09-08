def solution(weights, head2head):
    # [승률, 몸무게가 무거운 복서를 이긴 횟수, 몸무게, 번호]
    answer = []
    people_count = len(weights)
    result = []
    for i in range(people_count):
        # 승률
        if head2head[i].count('N') == len(head2head[i]): 
            # 한번도 붙어본 적이 없는 경우
            winrate = 0
        else: 
            # N인 케이스는 빼주어야 하므로
            winrate = head2head[i].count('W') / (head2head[i].count('W') + head2head[i].count('L')) 
        # 몸무게가 무거운 복서를 이김
        heavy_win_count = len([1 for j in range(people_count) if weights[i] < weights[j] and head2head[i][j] == 'W'])
        # 몸무게, 번호 추가해서 리스트에 추가
        result.append([winrate, heavy_win_count, weights[i], i+1])
    
    # 정렬(승률 내림차, 무거운 복서 이긴 횟수 내림차, 몸무게 내림차, 번호 오름차)
    result.sort(key=lambda x:(-x[0], -x[1], -x[2], x[3]))
    
    for _, __, ___, n in result:
        answer.append(n)
        
    return answer
