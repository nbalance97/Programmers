def solution(sizes):
    answer = 0
    
    card_w = 0
    card_h = 0
    for w, h in sizes:
        temp_w1, temp_h1 = max(w, card_w), max(h, card_h)
        temp_w2, temp_h2 = max(w, card_h), max(h, card_w)
        
        if temp_w1 * temp_h1 < temp_w2 * temp_h2:
            card_w, card_h = temp_w1, temp_h1
        else:
            card_w, card_h = temp_w2, temp_h2
    
    answer = card_w * card_h
    return answer
