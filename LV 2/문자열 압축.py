def solution(s):
    answer = len(s)
    
    for step in range(1, len(s)//2+1):
        pos = 0
        make_string = ''
        while pos < len(s):
            count = 1
            temp = s[pos:pos+step]
            pos = pos + step
            for pos in range(pos, len(s), step):
                if temp == s[pos:pos+step]:
                    count += 1
                    pos = pos + step
                else:
                    break

            if count > 1:
                make_string += (str(count) + temp)
            else:
                make_string += temp

        answer = min(answer, len(make_string))
        
    return answer

# 기존 작성한 소스코드(교재 참고)
# def solution(s):
#     answer = len(s)
#     myStr = ''
#     for i in range(1, len(s)//2+1):
#         count = 1
#         compare = s[:i]
#         for j in range(i, len(s), i):
#             if s[j:j+i] == compare:
#                 count += 1
#             else:
#                 if count == 1:
#                     myStr += compare
#                 else:
#                     myStr += (str(count) + compare)
#                 count = 1
#                 compare = s[j:j+i]
                
#         if count == 1:
#             myStr += compare
#         else:
#             myStr += (str(count) + compare)
            
#         answer = min(answer, len(myStr))
#         myStr = ''
            
# return answer
            
        
