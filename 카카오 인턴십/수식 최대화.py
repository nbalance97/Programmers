from itertools import permutations

def solution(expression):
    answer = 0
    operator = []
    element = []
    fi = 0
    for i in range(len(expression)):
        if expression[i] in ['*', '-', '+']:
            operator.append(expression[i])
            element.append(int(expression[fi:i]))
            fi = i + 1
    element.append(int(expression[fi:]))
    
    exist_op = set(operator)
    oper_sequence = list(permutations(exist_op))
    
    for oper in oper_sequence:
        cur_op = list(operator)
        cur_el = list(element)
        
        for op in oper: # sequence에 따른 계산결과
            temp_op = []
            temp_el = []
            temp_el.append(cur_el[0]) # 수식 계산시 맨앞은 미리 스택에 넣어줍니다.
            for i in range(len(cur_op)):
                if cur_op[i] == op:
                    # 매칭되는 operator의 경우 operator에 따라 스택 맨위의 요소와 계산 후 다시 넣어줍니다.
                    if op == "+":
                        result = temp_el[-1] + cur_el[i+1]
                        temp_el.pop()
                        temp_el.append(result)
                    elif op == "-":
                        result = temp_el[-1] - cur_el[i+1]
                        temp_el.pop()
                        temp_el.append(result)
                    elif op == "*":
                        result = temp_el[-1] * cur_el[i+1]
                        temp_el.pop()
                        temp_el.append(result)
                else: # 매칭 안되는건 그냥 넣어줍니다. (이 때 연산자도 같이 넣어주어야 함.)
                    temp_op.append(cur_op[i])
                    temp_el.append(cur_el[i+1])
                        
            cur_op = list(temp_op)
            cur_el = list(temp_el)
        answer = max(answer, abs(cur_el[0]))
    return answer
