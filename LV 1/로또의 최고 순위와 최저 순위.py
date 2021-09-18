def solution(lottos, win_nums):
    zero_count = len([lotto for lotto in lottos if lotto == 0])
    current_count = len([lottos[i] for i in range(len(lottos)) if lottos[i] in win_nums])
    
    high_rank = min(6, 7 - (current_count + zero_count))
    low_rank = min(6, 7 - (current_count))

    answer = [high_rank, low_rank]
    return answer
