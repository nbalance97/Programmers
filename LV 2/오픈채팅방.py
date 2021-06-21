def solution(record):
    answer = []
    username = {}
    for st in record:
        temp = st.split()
        if temp[0] == 'Enter' or temp[0] == 'Change':
            username[temp[1]] = temp[2]
    
    for st in record:
        temp = st.split()
        if temp[0] == 'Enter':
            answer.append(username[temp[1]]+'님이 들어왔습니다.')
        elif temp[0] == 'Leave':
            answer.append(username[temp[1]]+'님이 나갔습니다.')
            
    return answer
