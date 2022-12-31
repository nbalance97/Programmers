def solution(storey):
    answer = 0

    numbers = list(map(int, list(str(storey))))
    numbers = numbers[::-1]
        
    numbers.append(0)
    
    for idx, number in enumerate(numbers):      
        if number < 5:
            answer += number
        else:
            answer += (10 - number)
            
            if number == 5:
                if numbers[idx+1] >= 5:
                    numbers[idx+1] += 1
            else:
                numbers[idx+1] += 1
            
            s = idx + 1
            while numbers[s] == 10:
                numbers[s] = 0
                numbers[s+1] += 1
                s += 1
        
    return answer
