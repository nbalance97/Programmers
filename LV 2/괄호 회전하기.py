from collections import deque

def check(s):
    st = deque()
    for t in s:
        if t in ['[', '(', '{']:
            st.append(t)
        else:
            if len(st) == 0:
                return False
            temp = st.pop()
            if (temp == '[' and t == ']') or (temp == '(' and t == ')') or (temp == '{' and t == '}'):
                continue
            return False
    if st: # 스택에 차있으면 False임! 이거 처리 안해서 13번 통과 못했었음.
        return False
    
    return True

def solution(s):
    answer = 0
    for i in range(len(s)):
        temp = s[i:] + s[:i] # 회전
        if check(temp):
            answer += 1
    return answer
