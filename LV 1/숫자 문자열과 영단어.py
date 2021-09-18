def solution(s):
    string_dict = {'zero': 0, 'one': 1, 'two': 2, 'three': 3,
                  'four': 4, 'five': 5, 'six': 6, 'seven': 7,
                  'eight': 8, 'nine': 9}    
    answer = 0
    for string in string_dict.keys():
        if string in s: 
            # 입력받은 문자열에 영어 문자열이 있으면 숫자로 변환
            s = s.replace(string, str(string_dict[string]))
    answer = int(s)
    return answer
